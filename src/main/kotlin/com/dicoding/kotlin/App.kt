fun main() {
    val hololiveMember : ArrayList<String> = ArrayList()
    val hololiveAge : ArrayList<String> = ArrayList()
    addMember(hololiveMember)
    addAge(hololiveAge)
    welcome()
    val number : Int = 0;
    val chosenMember : String = hololiveMember[number]
    val chosenMemberAge : String = hololiveAge[number]
    println(memberDetails(chosenMember, chosenMemberAge))
    println(isPettan(chosenMember))
    println(isHydrodynamic(chosenMember))
}

//    Safe Calls Operator Example
fun safeCallsOperator(){
    val text : String? = null
    println(text?.length)
}

//    Elvis Calls Example
fun elvisOperator(){
    val text: String? = null
    val textLength = text?.length ?: "String kosong"
    println(textLength)
}

//    Procedure Example
fun welcome(){
    println("Welcome to Hololive")
}

//    Enumeration Example
enum class memberData(val memberName : String, val memberAge : String) {
    GURA("Gawr Gura","9485"),
    AME("Amelia Watson","Unknown"),
    INA("Ninomae Inanis","Unknown"),
    KIARA("Takanashi Kiara","Eternal"),
    CALLI("Mori Calliope","No"),
    HOPE("IRyS","As long as hope has been in your heart")
}

fun addMember(memberList: ArrayList<String>) {
    memberList.add(memberData.GURA.memberName)
    memberList.add(memberData.AME.memberName)
    memberList.add(memberData.INA.memberName)
    memberList.add(memberData.KIARA.memberName)
    memberList.add(memberData.CALLI.memberName)
    memberList.add(memberData.HOPE.memberName)
}

fun addAge(ageList: ArrayList<String>) {
    ageList.add(memberData.GURA.memberAge)
    ageList.add(memberData.AME.memberAge)
    ageList.add(memberData.INA.memberAge)
    ageList.add(memberData.KIARA.memberAge)
    ageList.add(memberData.CALLI.memberAge)
    ageList.add(memberData.HOPE.memberAge)
}

fun memberDetails(name: String, age: String) : String = "Name \t= $name \nAge \t= $age"

fun isPettan(name: String) : String {
    return if(name.equals("Gawr Gura") or name.equals("Ninomae Inanis")) {
        "$name is pettan"
    } else {
        "$name is not pettan"
    }
}

fun isHydrodynamic(name: String) : String {
    return "$name ${if(name == "Gawr Gura" || name == "Ninomae Inanis") "is hydrodynamic" else "is not hydrodynamic"}"
}