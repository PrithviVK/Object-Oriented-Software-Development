package edu.umb.cs681.hw07;
import java.time.LocalDateTime;


public abstract class FSElement {
	public Directory parent;
	protected String name;
	protected int size;
	protected static LocalDateTime creationTime;
	
	public FSElement(Directory parent,String name,int size, LocalDateTime creationTime) {
		this.name=name;
		this.size=size;
		this.creationTime=creationTime;
		this.parent=parent;
	}
	
	public Directory getParent() {
		return this.parent;	
	}
	
	public void setParent(Directory parent) {
		this.parent=parent;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		if(this.isDirectory()) {
			this.size=0;
		}
		else {
			this.size=size;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public LocalDateTime getDateTime() {
		return this.creationTime;
	}
	
	public void setDateTime(LocalDateTime creationTime) {
		this.creationTime=creationTime;
	}
	
	
	public abstract boolean isDirectory();
	public abstract boolean isFile();
	protected abstract boolean isLink();

	

		
}