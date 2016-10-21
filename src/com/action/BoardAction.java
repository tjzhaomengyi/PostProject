package com.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.orm.Admin;
import com.orm.Board;
import com.service.IBoardService;

public class BoardAction extends ActionSupport{
	@Resource(name="boardService")
	IBoardService boardService;
	
	private List<Board> boardList;
	//子节点
	private List<Board> childBoards;
	//根节点
	private List<Board> rootBoards;
	
	private Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Board> getChildBoards() {
        return childBoards;
    }

    public void setChildBoards(List<Board> childBoards) {
        this.childBoards = childBoards;
    }
    
     public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }
    public List<Board> getRootBoards() {
        return rootBoards;
    }

    public void setRootBoards(List<Board> rootBoards) {
        this.rootBoards = rootBoards;
    }
    
    
    //加载主板块
    @Override
    public String execute() throws Exception {
    	try {
    		loadRootBoards();
    		return SUCCESS;
    	} catch (Exception e){
    		return ERROR;
    	}
    }
    
    //加载所有板块
    public String listBoard() throws Exception{
    	try{
    		setBoardList(boardService.loadAllBoards());
    		return SUCCESS;
    	}catch(Exception e){
    		e.printStackTrace();
    		return ERROR;
    	}
    }
    
	//加载二级板块
    public String listChildBoards() throws Exception
    {
    	int parentId = Integer.valueOf(ServletActionContext.getRequest().getParameter("parentId"));
    	try{
    		loadRootBoards();
    		setChildBoards(boardService.loadChildBoards(parentId));
    		return SUCCESS;
    	} catch (Exception e){
    		e.printStackTrace();
    		return ERROR;
    	}
    }
	//加载根板块
    public String loadRootBoards() throws Exception{
    	try{
    		setRootBoards(boardService.loadRootBoards());
    		return SUCCESS;
    	}catch(Exception e){
    		e.printStackTrace();
    		return ERROR;
    	}
    }
    
    //跳转添加板块
    public String prepareAddBoard() throws Exception{
    	try{
    		setBoardList(boardService.loadAllBoards());
    		return "addBoard";
    	} catch (Exception e){
    		e.printStackTrace();
    		return ERROR;
    	}
    }
    
    //添加板块
    public String addBoard() throws Exception{
    	Admin admin = (Admin) ServletActionContext.getRequest().getSession().getAttribute("admin");
    	//这里想获取parentID，不会，转换为获取板块ID
    	//获取板块id，判断添加1级板块或者下级板块首先取出parentID
    	int bid = getBoard().getId();
    	int parentId = 0;
    	Board tempBoard = new Board();
    	//赋值时候判空，
    	try{
    		if(bid == -1){
    			tempBoard.setName(getBoard().getName());
    			tempBoard.setAdmin(admin);
    			tempBoard.setDescription(getBoard().getDescription());
    			//提交
    			if(boardService.saveOrUpdateBoard(tempBoard)){
    				return "addSuccess";
    			}
    			return ERROR;
    		}
    		//处理添加二级板块
    		else{
    		//根据Id加载被添加子版块的父板块
    			Board board = boardService.loadBoard(bid);
    			tempBoard.setName(getBoard().getName());
    			tempBoard.setAdmin(admin);
    			tempBoard.setBoard(board);
    			tempBoard.setDescription(getBoard().getDescription());
    			//提交
    			if(boardService.saveOrUpdateBoard(tempBoard)){
    				return "addSuccess";
    			}
    				return ERROR;
    		}
    	}catch (Exception e){
    		e.printStackTrace();
    		return ERROR;
    	}
    	
    }
    
    public String prepareModifyBoard() throws Exception{
    	//获取板块ID
    	HttpServletRequest request = ServletActionContext.getRequest();
    	int bid = 0;
    	if(request.getParameter("bid")!=null){
    		bid = Integer.valueOf(request.getParameter("bid").toString());
    	}
    	setBoard(boardService.loadBoard(bid));
    	loadRootBoards();
    	return "prepareModifyBoard";
    }
    
}
