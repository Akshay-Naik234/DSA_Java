package com.akshay.graph.MST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_721 {
	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		HashMap<String, Integer> map = new HashMap<>();
		int n = accounts.size();
		DisJointSet ds = new DisJointSet(n);
		for(int i=0;i<n;i++) {
			for(int j=1;j<accounts.get(i).size();j++) {
				String email = accounts.get(i).get(j);
				if(!map.containsKey(email)) {
					map.put(email, i);
				}
				else {
					ds.unionByRank(i, map.get(email));
				}
			}
		}
		ArrayList<String>[] mergedMail = new ArrayList[n];
		for(int i=0;i<n;i++) {
			mergedMail[i] = new ArrayList<String>();
		}
		for(Map.Entry<String, Integer> m : map.entrySet()) {
			String email = m.getKey();
			int value = m.getValue();
			int uParent = ds.getUParent(value);
			mergedMail[uParent].add(email);
		}
		List<List<String>> res = new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(mergedMail[i].size() == 0) {
				continue;
			}
			Collections.sort(mergedMail[i]);
			List<String> temp = new ArrayList<>();
			temp.add(accounts.get(i).get(0));
			for(String s:mergedMail[i]) {
				temp.add(s);
			}
			res.add(temp);
		}
		return res;
		
	}
	
	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };
        
        List<List<String>> ans = accountsMerge(accounts);

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }

            System.out.println("");
        }

	}
}
