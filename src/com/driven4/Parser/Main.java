package com.driven4.Parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		/** reading txt file and storing it in Arraylist **/
		List<String> myLines = new ArrayList<String>();
		File file = new File("D:\\JavaWorkspaces\\Interview_machineTests\\TextParser\\Sample-BOM-P031.txt");
		Scanner sc = new Scanner(file);
		int i = 0;
		while (sc.hasNextLine()) {
			myLines.add(sc.nextLine());
			i++;
		}
//		System.out.println(myLines);
		
		List<List<StringBuffer>> finalOutput = new ArrayList<List<StringBuffer>>();
		int lineIndex = 1;
		for (String eachLine : myLines) {
			List<StringBuffer> lkj = new ArrayList<StringBuffer>();
			String myLine = eachLine;

			if (myLine.charAt(0) == 'P') {

				char[] c = myLine.toCharArray();
				// System.out.println(c);

				/** adding part number */
				StringBuffer partno = new StringBuffer();
				for (int i1 = 0; i1 < 4; i1++) {
					partno.append(c[i1]);
				}
				System.out.print("part no-" + partno);

				/** adding quantity */
				StringBuffer qty = new StringBuffer();
				for (int i1 = 34; i1 < 36; i1++) {
					qty.append(c[i1]);
				}
				System.out.print(" quantity-" + qty);

				/** adding UOM */
				StringBuffer uom = new StringBuffer();
				for (int i1 = 42; i1 < 46; i1++) {
					uom.append(c[i1]);
				}
				System.out.print(" uom-" + uom);

				/** adding Description */
				StringBuffer descrpt = new StringBuffer();
				for (int i1 = 5; i1 < 34; i1++) {
					descrpt.append(c[i1]);
				}
				System.out.print(" description-" + descrpt + "\n");

				lkj.add(partno);
				lkj.add(descrpt);
				lkj.add(qty);
				lkj.add(uom);

				finalOutput.add(lkj);
				lineIndex++;
			} else {
				System.out.println("--------------------------------------------------------------------");
				String jh = myLine.toString();
				System.out.println("==>" + jh);

			}
		}
		// System.out.println(finalOutput);
	}

}
