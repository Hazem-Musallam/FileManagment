package file.managment;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;

import file.managment.dataStructure.search.Search;
import file.managment.dto.FileDto;

public class MainPoint {
	LinkedList<FileDto> llist = new LinkedList<FileDto>();

	public void listAllFilesAndDirectories(File curDir) {
		llist.clear();

		File[] filesList = curDir.listFiles();
		try {
			for (File f : filesList) {
				if (f.exists()) {
					FileDto fileDto = new FileDto();
					if (f.isDirectory()) {
						fileDto.setDir(true);
					} else {
						fileDto.setDir(false);
					}
					fileDto.setName(f.getName());
					if (!llist.contains(fileDto)) {
						llist.add(fileDto);
					}
				}
			}

		} catch (Exception e) {

			System.out.println("Please Correct Your Inputs");

		}
		// This binarySort
		Collections.sort(llist);
		// Print DAta
		System.out.println(llist);
	}

	public void deleteFile(String pathname, String fileName) {
		try {
			File currentFile = new File(pathname);
			if (!currentFile.exists()) {
				System.out.println("Please Make Sure That You Entered Correct Data can't delete not exist file");

			} else {
				currentFile.delete();
			}
			FileDto file = new FileDto();
			file.setName(fileName);
			llist.remove(file);
		} catch (Exception e) {
			System.out.println("Please Make Sure That You Entered Correct Data error in Deleting ");
		}
	}

	public boolean contaionThisFile(String fileName) {
		if (llist.size() == 0) {
			return false;
		}
		// This binarySort
		Collections.sort(llist);
		return Search.recursiveBinarySearch(llist, 0, llist.size() - 1, fileName) >= 0;
	}

	public boolean isExist(String pathnameNew) {
		return new File(pathnameNew).exists();
	}
}
