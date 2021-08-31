import java.util.Scanner

fun main() {
    val hololiveMember  = mutableListOf<String>()
    val hololiveAge  = mutableListOf<String>()
    addMember(hololiveMember)
    addAge(hololiveAge)
    val number = 0
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

//    Data Class Example
data class DataUser(val name : String, val age : String) {
    fun intro() {
        println("My name is $name, I am $age years old")
    }
}

//    Data Class Procedure Example
fun dataClassesExample(name: String, age: String) {
    val dataUser = DataUser(name, age)
    val dataUser4 = dataUser.copy(age = "18")
    println(dataUser4)
    dataUser4.intro()
}

//    Destructuring Declaration Example
fun destructuringDeclarationExample(name: String, age: String) {
    val dataUser = DataUser(name, age)

    val newName = dataUser.component1()
    val newAge = dataUser.component2()

    println("My name is $newName, I am $newAge years old")
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
fun addMember(memberList: MutableList<String>) {
    memberList.add(MemberData.GURA.memberName)
    memberList.add(MemberData.AME.memberName)
    memberList.add(MemberData.INA.memberName)
    memberList.add(MemberData.KIARA.memberName)
    memberList.add(MemberData.CALLI.memberName)
    memberList.add(MemberData.HOPE.memberName)
}
//    Add member age to ArrayList
fun addAge(ageList: MutableList<String>) {
    ageList.add(MemberData.GURA.memberAge)
    ageList.add(MemberData.AME.memberAge)
    ageList.add(MemberData.INA.memberAge)
    ageList.add(MemberData.KIARA.memberAge)
    ageList.add(MemberData.CALLI.memberAge)
    ageList.add(MemberData.HOPE.memberAge)
}

//    Loop Break Example
fun loopBreak() {
    val listOfInt = listOf(1,2,null,4,5)
    for (i in listOfInt) {
        if (i == null) break
        print(i)
    }
    println()
}

//    Loop Continue Example
fun loopContinue() {
    val listOfInt = listOf(1,2,null,4,5)
    for (i in listOfInt) {
        if (i == null) continue
        print(i)
    }
    println()
}

//    Label Expressions Example
fun labels(text: String) {
    loop@ for ( i in 1..10) {
        println(text)
        if(i == 5) break@loop
    }
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
        7 -> showLoopBreakMenu(chosenMember)
        8 -> showDataClassesCollectionMenu(chosenMember, chosenMemberAge)
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

//    Range Option Using When Expression
fun loopBreakMenuOption(option: Int, text: String) {
    when(option) {
        1 -> loopBreak()
        2 -> loopContinue()
        3 -> labels(text)
    }
}

//    DataClassesCollection Option Using When Expression
fun dataClassesCollectionMenuOption(option: Int, name: String, age: String) {
    when(option) {
        1 -> dataClassesExample(name,age)
        2 -> destructuringDeclarationExample(name,age)
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
    println("7. Break and Continue")
    println("8. Data Classes and Collections")
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

//    Show LoopBreak Menu
fun showLoopBreakMenu(text: String){
    println("Range Menu")
    println("1. Loop Break")
    println("2. Loop Continue")
    println("3. Label Expressions")
    print("Option : ")
    val scan = Scanner(System.`in`)
    val loopBreakOption = scan.nextInt()
    loopBreakMenuOption(loopBreakOption,text)
}

//    Show DataClassesCollection Menu
fun showDataClassesCollectionMenu(name: String, age: String){
    println("DataClassesCollection Menu")
    println("1. DataClasses")
    println("2. Destructuring Declaration")
    print("Option : ")
    val scan = Scanner(System.`in`)
    val dataClassesCollectionOption = scan.nextInt()
    dataClassesCollectionMenuOption(dataClassesCollectionOption,name,age)
}