package com.orm;

import java.util.HashSet;
import java.util.Set;

public class Board {

	private Integer id;
	private Board board;
	private Admin admin;
	private String name;
	private String description;
	private String boardImg;
	private Set posts = new HashSet(0);
	private Set boards = new HashSet(0);
	
	
	 public Board() {
	    }

		
	    public Board(Admin admin, String name) {
	        this.admin = admin;
	        this.name = name;
	    }
	    public Board(Board board, Admin admin, String name, String description, String boardImg, Set posts, Set boards) {
	       this.board = board;
	       this.admin = admin;
	       this.name = name;
	       this.description = description;
	       this.boardImg = boardImg;
	       this.posts = posts;
	       this.boards = boards;
	    }
	   
	    public Integer getId() {
	        return this.id;
	    }
	    
	    public void setId(Integer id) {
	        this.id = id;
	    }
	    public Board getBoard() {
	        return this.board;
	    }
	    
	    public void setBoard(Board board) {
	        this.board = board;
	    }
	    public Admin getAdmin() {
	        return this.admin;
	    }
	    
	    public void setAdmin(Admin admin) {
	        this.admin = admin;
	    }
	    public String getName() {
	        return this.name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getDescription() {
	        return this.description;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description;
	    }
	    public String getBoardImg() {
	        return this.boardImg;
	    }
	    
	    public void setBoardImg(String boardImg) {
	        this.boardImg = boardImg;
	    }
	    public Set getPosts() {
	        return this.posts;
	    }
	    
	    public void setPosts(Set posts) {
	        this.posts = posts;
	    }
	    public Set getBoards() {
	        return this.boards;
	    }
	    
	    public void setBoards(Set boards) {
	        this.boards = boards;
	    }

	
	
}
