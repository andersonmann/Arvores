package bst_AVL_2014_2;

import java.util.ArrayList;
import java.util.List;

public class EvenProcessor implements Processor {

	private List<Integer> result;

	public EvenProcessor() {
		result = new ArrayList<>();
	}

	@Override
	public void process(int x) {
		if (x % 2 == 0)
			result.add(x);
	}

	public List<Integer> getResult() {
		return result;
	}

}
