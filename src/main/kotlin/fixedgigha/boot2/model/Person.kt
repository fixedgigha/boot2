package fixedgigha.boot2.model

class Person {

    constructor() {}

    constructor(id: String, firstName: String, lastName: String, age: Int) {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.age = age
    }

    var id: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var age: Int = -1
}
