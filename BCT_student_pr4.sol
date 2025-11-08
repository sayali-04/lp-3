// SPDX-License-Identifier: MIT 
pragma solidity ^0.8.0; 
 
contract StudentData { 
    // Structure to store student details 
    struct Student { 
        uint256 id; 
        string name; 
        uint256 age; 
        string course; 
    } 
 
    // Dynamic array to store multiple students 
    Student[] public students; 
 
    // Event for logging student addition 
    event StudentAdded(uint256 id, string name); 
 
    // Function to add a new student 
    function addStudent(uint256 _id, string memory _name, uint256 _age, string memory 
_course) public { 
        students.push(Student(_id, _name, _age, _course)); 
        emit StudentAdded(_id, _name); 
    } 
 
    // Function to get the total number of students 
    function getStudentCount() public view returns (uint256) { 
        return students.length; 
    } 
 
    // Function to get a student's details by index 
    function getStudent(uint256 index) public view returns (uint256, string memory, uint256, 
string memory) { 
        require(index < students.length, "Invalid index"); 
        Student memory s = students[index]; 
        return (s.id, s.name, s.age, s.course); 
    } 
 
    // Fallback function — gets called when non-existent function or direct ether sent 
    fallback() external payable { 
        // Ether received without calling a function 
        // You can log or handle it here 
    } 
 
    // Receive function to accept plain Ether transfers 
    receive() external payable {} 
// Function to check the balance of the contract 
function getContractBalance() public view returns (uint256) { 
return address(this).balance; 
} 
}