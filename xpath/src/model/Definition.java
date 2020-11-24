package model;

public class Definition {
	private String xpath;
	private String name;
	private int lineNumber;
	private String type;
	
	public Definition(String xpath, String name, int lineNumber, String type) {
		super();
		this.xpath = xpath;
		this.name = name;
		this.lineNumber = lineNumber;
		this.type = type;
	}
	
	public Definition() {
		super();
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "xpath: " + this.xpath +
				"\\n name: " + this.name +
				"\\n lineNumber: " + this.lineNumber +
				"\\n type: " + this.type;
	}
}
