package com.tt.pin.view.expandlistview;

import java.util.ArrayList;

/**
 * 保存父的数据
 * @author shitao.tommy
 */
public class Parent {
	private String name;
	private String text1;
	private String text2;
	private String checkedType;
	private boolean checked;
	private ArrayList<Child> children;// ArrayList to store child objects
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	public String getText2() {
		return text2;
	}
	public void setText2(String text2) {
		this.text2 = text2;
	}
	public String getCheckedType() {
		return checkedType;
	}
	public void setCheckedType(String checkedType) {
		this.checkedType = checkedType;
	}

	public ArrayList<Child> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Child> children) {
		this.children = children;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
