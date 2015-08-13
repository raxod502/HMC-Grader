import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SortingStuffTest {
	/*
	 * Testing bubble and bubbleSort
	 */
	
	@Test
	public void testBubbleSorted() {
		int[] arr = {1,2,3,4};
		assertFalse("Bubble should return false on a sorted array", SortingStuff.bubble(arr));
	}

	@Test
	public void testBubbleUnsortedSmall() {
		int[] arr = {2,1};
		assertTrue("Bubble should return true if it had to swap elements", SortingStuff.bubble(arr));
	}

	@Test
	public void testBubbleUnsortedBig() {
		int[] arr = {3,1,2,6,5,7};
		assertTrue("Bubble should return true if it had to swap elements", SortingStuff.bubble(arr));
	}

	@Test
	public void testBubbleSort1() {
		int[] arr = {1,2,3,4};
		int[] res = {1,2,3,4};
		SortingStuff.bubbleSort(arr);
		assertArrayEquals("Bubble sort should leave a sorted array sorted", arr, res);
	}

	@Test
	public void testBubbleSort2() {
		int[] arr = {4,3,2,1};
		int[] res = {1,2,3,4};
		SortingStuff.bubbleSort(arr);
		assertArrayEquals("Bubble sort sort the array", arr, res);
	}

	@Test
	public void testBubbleSort3() {
		int[] arr = {9,3,6,5,4,4,2,1,8,3,7};
		int[] res = {1,2,3,3,4,4,5,6,7,8,9};
		SortingStuff.bubbleSort(arr);
		assertArrayEquals("Bubble sort sort the array even with duplicates", arr, res);
	}

	/*
	 * Test insert and insertionSort
	 */

	@Test
	public void testInsert() {
		int[] arr = {1,2,4,3};
		int[] res = {1,2,3,4};
		SortingStuff.insert(arr, 3);
		assertArrayEquals("Insert should place the element in the sorted location", arr, res);
	}

	@Test
	public void testInsertionSort1() {
		int[] arr = {1,2,3,4};
		int[] res = {1,2,3,4};
		SortingStuff.insertionSort(arr);
		assertArrayEquals("Insertion sort should leave a sorted array sorted", arr, res);
	}

	@Test
	public void testInsertionSort2() {
		int[] arr = {4,3,2,1};
		int[] res = {1,2,3,4};
		SortingStuff.insertionSort(arr);
		assertArrayEquals("Insertion sort sort the array", arr, res);
	}

	@Test
	public void testInsertionSort3() {
		int[] arr = {9,3,6,5,4,4,2,1,8,3,7};
		int[] res = {1,2,3,3,4,4,5,6,7,8,9};
		SortingStuff.insertionSort(arr);
		assertArrayEquals("Insertion sort sort the array even with duplicates", arr, res);
	}

	/*
	 * Test minIndex and selectionSort
	 */
	
	@Test
	public void testMinIndexUnsorted() {
		int[] arr = {5,6,7,2,1};
		assertEquals("minIndex should find the index of the minimum element in the array", SortingStuff.minIndex(arr, 0), 4);
	}
	
	@Test
	public void testMinIndexPartialSort() {
		int[] arr = {1,2,3,8,9,4,7};
		assertEquals("minIndex should find the index of the minimum element in the array", SortingStuff.minIndex(arr, 3), 5);
	}

	@Test
	public void testSelectionSort1() {
		int[] arr = {1,2,3,4};
		int[] res = {1,2,3,4};
		SortingStuff.selectionSort(arr);
		assertArrayEquals("Selection sort should leave a sorted array sorted", arr, res);
	}

	@Test
	public void testSelectionSort2() {
		int[] arr = {4,3,2,1};
		int[] res = {1,2,3,4};
		SortingStuff.selectionSort(arr);
		assertArrayEquals("Selection sort sort the array", arr, res);
	}

	@Test
	public void testSelectionSort3() {
		int[] arr = {9,3,6,5,4,4,2,1,8,3,7};
		int[] res = {1,2,3,3,4,4,5,6,7,8,9};
		SortingStuff.selectionSort(arr);
		assertArrayEquals("Selection sort sort the array even with duplicates", arr, res);
	}	
}
