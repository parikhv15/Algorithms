package HackerRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StringSort {


  private Map<String, Integer> tempMap;

  public StringSort() {
    this.tempMap = new HashMap<>();

    this.tempMap.put("zero", 0);
    this.tempMap.put("one", 1);
    this.tempMap.put("two", 2);
    this.tempMap.put("three", 3);
    this.tempMap.put("four", 4);
    this.tempMap.put("five", 5);
    this.tempMap.put("six", 6);
    this.tempMap.put("seven", 7);
    this.tempMap.put("eight", 8);
    this.tempMap.put("nine", 9);
    this.tempMap.put("eleven", 11);
    this.tempMap.put("twelve", 12);
    this.tempMap.put("thirteen", 13);
    this.tempMap.put("fourteen", 14);
    this.tempMap.put("fifteen", 15);
    this.tempMap.put("sixteen", 16);
    this.tempMap.put("seventeen", 17);
    this.tempMap.put("eighteen", 18);
    this.tempMap.put("nineteen", 19);
    this.tempMap.put("ten", 10);
    this.tempMap.put("twenty", 20);
    this.tempMap.put("thirty", 30);
    this.tempMap.put("fourty", 40);
    this.tempMap.put("fifty", 50);
    this.tempMap.put("sixty", 60);
    this.tempMap.put("seventy", 70);
    this.tempMap.put("eighty", 80);
    this.tempMap.put("ninety", 90);
  }

  public static void main(String[] args) {
    StringSort stringSort = new StringSort();

    stringSort.sort(args);
  }

  public void sort(String[] strings) {
    StringSortComparator comparator = new StringSortComparator();

    System.out.println(comparator.stringToNumber("one-hundred-million-twenty-five"));
    System.out.println(comparator.stringToNumber("three-hundred-fourty-eight-million-nine-thousand-seven-hundred-twenty-five"));

    Arrays.sort(strings, comparator);
  }

  class StringSortComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      String[] oArr1 = o1.split("\\\\s+");
      String[] oArr2 = o2.split("\\\\s+");

      int compare = oArr1[0].compareTo(oArr2[0]);

      if (compare == 0) {
        // Compare the integer part
        compare = compareNumericStrings(oArr1[1], oArr2[1]);
      }

      return compare;
    }

    private int compareNumericStrings(String s1, String s2) {
      int n1 = stringToNumber(s1);
      int n2 = stringToNumber(s2);

      return Integer.compare(n1, n2);
    }

    int stringToNumber(String s) {
      String[] sArr = s.split("-");
      int previous = 0, result = 0;

      for (String temp : sArr) {
        if (tempMap.containsKey(temp)) {
          previous += tempMap.get(temp);
        } else if (temp.equals("hundred")) {
          previous *= 100;
        } else if (temp.equals("thousand")) {
          previous *= 1000;
          result += previous;
          previous = 0;
        } else if (temp.equals("million")) {
          previous *= 1000000;
          result += previous;
          previous = 0;
        }
      }

      return result + previous;
    }
  }
}
