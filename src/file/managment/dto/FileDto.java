package file.managment.dto;

public class FileDto implements Comparable<FileDto> {
	private String name;

	private boolean isDir;

	public FileDto(String fileName) {
		this.name = fileName;
	}

	public FileDto() {
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDir() {
		return isDir;
	}

	public void setDir(boolean isDir) {
		this.isDir = isDir;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FileDto) {
			FileDto o2 = (FileDto) obj;
			return name.equalsIgnoreCase(o2.getName());
		}
		return false;
	}

	@Override
	public int compareTo(FileDto o) {
		return this.name.compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "{ File Name [".concat(getName()).concat("] - ").concat("Is Dir " + isDir + " }");

	}
}
