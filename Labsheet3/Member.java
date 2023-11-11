class Member{
    private String name = "JACEThie";
    private int yearJoined;
    private String membershipType;

    public Member(String desiredName, int joinYear){
        // setName(desiredName);
        setJoinYear(joinYear);
        membershipType = "Normal";
    }

    public static void main(String[] args){
        Member member1 = new Member("Lyle", 2004);
        System.out.println(member1.getName());
        System.out.println(member1.getJoinDate());
    }
    
    private void setName(String desiredName){
        name = desiredName;
    }

    private void setJoinYear(int joinYear){
        yearJoined = joinYear;
    }

    private void setStudent(){
        membershipType = "Student";
    }
    
    public String getName(){
        return name;
    }
    
    public int getJoinDate(){
        return yearJoined;
    }
    
    public String getMembershipType(){
        return membershipType;
    }


}