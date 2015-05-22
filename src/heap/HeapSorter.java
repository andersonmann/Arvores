package heap;

import java.util.Arrays;

public class HeapSorter {
	private static int[] a;
	private static int n;

	public static void sort(int[] a0) {
		a = a0;
		n = a.length;
		heapsort();
	}

	private static void heapsort() {
		buildheap();

		while (n > 1) {
			n--;
			exchange(0, n);
			downheap(0);
		}
	}

	private static void buildheap() {
		for (int v = n / 2 - 1; v >= 0; v--)
			downheap(v);
	}

	private static void downheap(int v) {
		int w = 2 * v + 1; // first descendant of v
		while (w < n) {
			System.out.println(Arrays.toString(a));

			if (w + 1 < n) // is there a second descendant?
				if (a[w + 1] > a[w])
					w++;
			// w is the descendant of v with maximum label

			if (a[v] >= a[w])
				return; // v has heap property
			// otherwise
			exchange(v, w); // exchange labels of v and w
			v = w; // continue
			w = 2 * v + 1;
		}
		System.out.println(Arrays.toString(a));

	}

	private static void exchange(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		// int[] v = { 5, 4, 1, 3, 2 };
		int[] v = { 1, 2, 3, 4, 5 };
		HeapSorter.sort(v);
	}
}
