package file.managment.dataStructure;

import file.managment.dto.FileDto;

@SuppressWarnings("unused")
public class LinkedList {
	Node head;

	class Node {
		FileDto data;
		Node next;

		Node(FileDto d) {
			data = d;
		}
	}
}