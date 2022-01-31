package Advanced;

import java.util.ArrayList;
import java.util.Scanner;

public class Traverse {
    int N, pathsNum, startNode, destNode;
    ArrayList<Integer>[] lst;

    public ArrayList<Integer>[] get_Input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter No.of nodes:");
        int i=1,node1, node2;
        N = in.nextInt();
        System.out.println("Enter No.of paths:");
        pathsNum = in.nextInt();
        System.out.println("Enter Start Node:");
        startNode = in.nextInt();
        System.out.println("Enter Destination Node:");
        destNode = in.nextInt();
        lst = new ArrayList[N];
//        lst = new ArrayList<ArrayList<Integer> >(N);
        while (i<=pathsNum){
            node1 = in.nextInt();
            node2 = in.nextInt();
            if(lst[node1-1] == null) lst[node1-1]= new ArrayList<>();
            if(lst[node2-1] == null) lst[node2-1]= new ArrayList<>();

//            if (lst.isEmpty())lst.add(node1-1,new ArrayList<>(node2));
//            if (lst.isEmpty())lst.add(node2-1,new ArrayList<>(node1));



//            lst.add(node1-1,new ArrayList<>(node2));
//            lst.add(node2-1,new ArrayList<>(node1));


            lst[node1-1].add(node2);
            lst[node2-1].add(node1);
            i++;
        }

        return lst;

    }

    public void printList(ArrayList<Integer>[] lst){
        System.out.println();
        for (int i = 0; i < lst.length; i++) {
            System.out.print(i+1+"->");

            for (int j = 0; j < lst[i].size(); j++) {
                System.out.print(lst[i].get(j) + " ");
            }
            System.out.println();
        }
    }
    public void printList(ArrayList<ArrayList<Integer>> lst){
        System.out.println();
        for (int i = 0; i < lst.size(); i++) {
            System.out.print(i+1+"->");

            for (int j = 0; j < lst.get(i).size(); j++) {
                System.out.print(lst.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> successfulPaths(){
        ArrayList<ArrayList<Integer>> pathsFound = new ArrayList<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer>currPath = new ArrayList<>();
        pathsFound.add(lst[startNode-1]);
        int pathNum =0,topNode;
//        topNode = pathsFound.get(startNode-1).get(0);
        currPath.add(startNode);

        while(!currPath.isEmpty()){
            while(!pathsFound.get(pathNum).isEmpty()){
                topNode=pathsFound.get(pathNum).get(0);



//                else{
                    if(currPath.contains(topNode)){
                        pathsFound.get(pathNum).remove(0);

                    }
                    else{
                        currPath.add(topNode);
                        if(topNode==destNode){
                            System.out.println("Current Path At Destination:" + currPath);
                            ArrayList<Integer>temp = new ArrayList<>(currPath);
                            paths.add(temp);
                            currPath.remove(currPath.size()-1);
                            pathsFound.get(pathNum).remove(0);
                        }
                        else {

                            pathNum++;
                            ArrayList<Integer>temp1 = new ArrayList<>(lst[topNode - 1]);
                            pathsFound.add(temp1);
                            // System.out.println("Current Path After:" + currPath);
                        }
                    }
//                }
            }
            pathsFound.remove(pathNum);
            pathNum--;
            if(pathNum>=0) {
                System.out.println("Current Path Before:" + currPath);
//               topNode = pathsFound.get(pathNum).get(0);
               pathsFound.get(pathNum).remove(0);
               currPath.remove(currPath.size() - 1);
               System.out.println("Current Path After:"+currPath);
            }
            else{
                currPath.remove(0);
            }
        }

        return paths;

    }

    public static void main(String[] args) {
        Traverse T = new Traverse();
        var l =T.get_Input();
        T.printList(l);
        T.printList(T.successfulPaths());
//        var outPaths=T.successfulPaths();
//        T.printList(outPaths);
    }
}
