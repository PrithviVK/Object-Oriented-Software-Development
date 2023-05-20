package edu.umb.cs681.hw07;
import java.time.LocalDateTime;


public class Link extends FSElement {
	
	private FSElement target;
	public Link(Directory parent,String name,int size,LocalDateTime creationTime,FSElement target) {
		super(parent,name,0,creationTime);
		this.target=target;
	}
	
	public int getTargetsize() {
		return target.getSize();
	}
	
	public void setTarget(FSElement target) {
		this.target=target;
	}
//	
	public FSElement getTarget() {
		return this.target;
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	@Override
	public boolean isFile() {
		return false;
	}
	
	public boolean isLink() {
		return true;
	}
	
	public boolean isTargetDirectory() {
		return target.isDirectory();
	}
	
	public boolean isTargetFile() {
		return target.isFile();
	}
	
	public boolean isTargetLink() {
		return target.isLink();
	}
	
	
}