import java.util.Scanner
import kotlin.collections.ArrayList

fun main() {
    val hololiveMember : ArrayList<String> = ArrayList()
    val hololiveAge : ArrayList<String> = ArrayList()
    addMember(hololiveMember)
    addAge(hololiveAge)
    val number = 5
    val chosenMember : String = hololiveMember[number]
    val chosenMemberAge : String = hololiveAge[number]
    do{
        showMenu(chosenMember)
        print("Option : ")
        val scan = Scanner(System.`in`)
        val option = scan.nextInt()
        menuOption(option,chosenMember,chosenMemberAge)
    } while (option != 99)
}

//    Safe Calls Operator Example
fun safeCallsOperator(){
    val text : String? = null
    println(text?.length)
}

//    Elvis Calls Operator Example
fun elvisOperator(){
    val text: String? = null
    val textLength = text?.length ?: "String kosong"
    println(textLength)
}

//    Procedure Example
fun welcome(name: String){
    println("Welcome $name")
}

//    Enumeration Example
enum class MemberData(val memberName : String, val memberAge : String) {
    GURA("Gawr Gura","9485"),
    AME("Amelia Watson","Unknown"),
    INA("Ninomae Inanis","Unknown"),
    KIARA("Takanashi Kiara","Eternal"),
    CALLI("Mori Calliope","No"),
    HOPE("IRyS","As long as hope has been in your heart")
}

//    When Expression Example
fun getNickname(name: String) : String {
    return when(name) {
        "Gawr Gura" -> "Same-chan"
        "Amelia Watson" -> "Ame"
        "Ninomae Inanis" -> "Tako"
        "Takanashi Kiara" -> "Kusotori "
        "Mori Calliope" -> "Calli"
        "IRyS" -> "irysocool "
        else -> "Unknown"
    }
}

//    While Loop Example
fun loopingUsingWhile(text: String){
    var counter = 1
    while (counter <= 5) {
        println("$text using while")
        counter++
    }
}

//    Do While Loop Example
fun loopingUsingDoWhile(text: String){
    var counter = 1
    do {
        println("$text using do while")
        counter++
    } while(counter <= 5)
}

//    For Loop Example + print index
fun loopingUsingFor(text: String){
    val ranges = 5.downTo(1)
    for ((index, value) in ranges.withIndex()){
        println("$text $index using for looping with value : $value")
    }
}

//    Foreach Loop Example + print index
fun loopingUsingForeach(text: String){
    val ranges = 5.downTo(1)
    ranges.forEachIndexed { index, value ->
        println("$text $index using foreach looping with value : $value")
    }
}

//    Range 1..0 Using 1 Step
fun usingRange(){
    val rangeInt = 1..10 step 1
    rangeInt.forEach { value->
        print("$value ")
    }
    println()
}

//    Range 1..0 Using 2 Step
fun usingRangeTo(){
    val rangeInt = 1.rangeTo(10) step 2
    rangeInt.forEach { value->
        print("$value ")
    }
    println()
}

//    Finding Value 1 in Range 10..1 Using 3 Step
fun findValueUsingDownTo(){
    val rangeInt = 10.downTo(1) step 3
    if(1 in rangeInt){
        println("Value 1 is available")
    }
    println()
}

//    Add member to ArrayList
fun addMember(memberList: ArrayList<String>) {
    memberList.add(MemberData.GURA.memberName)
    memberList.add(MemberData.AME.memberName)
    memberList.add(MemberData.INA.memberName)
    memberList.add(MemberData.KIARA.memberName)
    memberList.add(MemberData.CALLI.memberName)
    memberList.add(MemberData.HOPE.memberName)
}
//    Add member age to ArrayList
fun addAge(ageList: ArrayList<String>) {
    ageList.add(MemberData.GURA.memberAge)
    ageList.add(MemberData.AME.memberAge)
    ageList.add(MemberData.INA.memberAge)
    ageList.add(MemberData.KIARA.memberAge)
    ageList.add(MemberData.CALLI.memberAge)
    ageList.add(MemberData.HOPE.memberAge)
}

//    Print member details
fun memberDetails(name: String, age: String) : String = "Name \t\t= $name \nAge \t\t= $age\nNickname \t= ${getNickname(name)}"

//    Pettan checker (lol)
fun isPettan(name: String) : String {
    return if(name == "Gawr Gura" || name == "Ninomae Inanis") {
        "$name is pettan"
    } else {
        "$name is not pettan"
    }
}

//    Hydrodynamic checker (lol)
fun isHydrodynamic(name: String) : String {
    return "$name ${if(name == "Gawr Gura" || name == "Ninomae Inanis") "is hydrodynamic" else "is not hydrodynamic"}"
}

//    Menu Option Using When Expression
fun menuOption(option: Int, chosenMember: String, chosenMemberAge: String) {
    when(option) {
        1 -> println(memberDetails(chosenMember, chosenMemberAge))
        2 -> println(isPettan(chosenMember))
        3 -> println(isHydrodynamic(chosenMember))
        4 -> showOperatorMenu()
        5 -> showLoopingMenu(chosenMember)
        6 -> showRangeMenu()
    }
}

//    Operation Option Using When Expression
fun operatorMenuOption(option: Int) {
    when(option) {
        1 -> safeCallsOperator()
        2 -> elvisOperator()
    }
}

//    Looping Option Using When Expression
fun loopingMenuOption(option: Int, chosenMember: String) {
    when(option) {
        1 -> loopingUsingWhile(chosenMember)
        2 -> loopingUsingDoWhile(chosenMember)
        3 -> loopingUsingFor(chosenMember)
        4 -> loopingUsingForeach(chosenMember)
    }
}

//    Range Option Using When Expression
fun rangeMenuOption(option: Int) {
    when(option) {
        1 -> usingRange()
        2 -> usingRangeTo()
        3 -> findValueUsingDownTo()
    }
}

//    Show Menu
fun showMenu(chosenMember : String){
    welcome(chosenMember)
    println("1. Bio")
    println("2. Pettan checker")
    println("3. Hydrodynamic checker")
    println("4. Operator")
    println("5. Looping")
    println("6. Range")
}

//    Show Operator Menu
fun showOperatorMenu(){
    println("Operator Menu")
    println("1. Safe Calls Operator")
    println("2. Elvis Calls Operator")
    print("Option : ")
    val scan = Scanner(System.`in`)
    val operationOption = scan.nextInt()
    operatorMenuOption(operationOption)
}

//    Show Looping Menu
fun showLoopingMenu(text: String){
    println("Looping Menu")
    println("1. Looping using while")
    println("2. Looping using do while")
    println("3. Looping using for + print index")
    println("4. Looping using foreach + print index")
    print("Option : ")
    val scan = Scanner(System.`in`)
    val loopingOption = scan.nextInt()
    loopingMenuOption(loopingOption, text)
}

//    Show Range Menu
fun showRangeMenu(){
    println("Range Menu")
    println("1. Range using \"..\"")
    println("2. Range using \"rangeTo\"")
    println("3. Finding Value 1 in Range using \"downTo\"")
    print("Option : ")
    val scan = Scanner(System.`in`)
    val rangeOption = scan.nextInt()
    rangeMenuOption(rangeOption)
}