package msm.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemberManagement implements FileUtils{
    private List<Member> members;
    private PrintWriter file2 = null;
    private BufferedReader file = null;

    public MemberManagement() {
        this.members = new ArrayList<>();
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }


    public void readData(String name, List<String> list) {
        String line = null;
        try {
            file = new BufferedReader(new FileReader(name));
            while ((line = file.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (line != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void writeData(String name, List<String> list2){
        try {
            file2  = new PrintWriter(new BufferedWriter(new FileWriter(name, false)));
            for (String s:list2) {
                file2.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (file2 != null) {
                file2.close();
            }
        }
    }

    public void addMember(Member m){
        members.add(m);
    }


}
