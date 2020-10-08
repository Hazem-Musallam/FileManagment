package file.managment.dataStructure.search;

import java.util.LinkedList;

import file.managment.dto.FileDto;

public class Search {
	public static int recursiveBinarySearch(LinkedList<FileDto> llist, int firstElement, int lastElement,
			String elementToSearch) {

		if (lastElement >= firstElement) {
			int mid = firstElement + (lastElement - firstElement) / 2;

			if (llist.get(mid).getName().equalsIgnoreCase(elementToSearch))
				return mid;

			if (llist.get(mid).getName().compareTo(elementToSearch) > 0)
				return recursiveBinarySearch(llist, firstElement, mid - 1, elementToSearch);

			return recursiveBinarySearch(llist, mid + 1, lastElement, elementToSearch);
		}

		return -1;
	}
}
