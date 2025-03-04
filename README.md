# DAILY CODING JOURNAL

This repository contains my daily coding practice questions and solutions. It covers various topics, including data structures, algorithms, problem-solving techniques, and Java programming patterns.

## 📌 Contents

- **Java Programs** (Basic to Advanced)
- **Data Structures & Algorithms**
- **Competitive Coding Questions**
- **Pattern Printing Programs**
- **Logical & Mathematical Problems**

## 📜 Menu (Problem List)
Below is a list of all the problems. Click on any problem to jump to its statement.

| Problem No. | Problem Name | Solution |
|-------------|-------------|----------|
| [Problem 1](#problem-1-ninja-and-locker) | **Ninja and Locker** | [Java](./Solutions%20in%20JAVA/Ninja_And_Locker.java)| 
| [Problem 2](#problem-2) | **Combine Two Tables** | [SQL](./SQL/combine-two-tables.sql)  |
| [Problem 3](#problem-3) | **Check For Dead End In A BST** | [Java](./Solutions%20in%20JAVA/CheckForDeadEnd_In_BST.java)  |


## 🚀 How to Use

1. Clone the repository:
   ```bash
   git clone https://github.com/kokkondaBhanuteja/Daily-Coding-Journal.git
   ```


## ✨ Contributions
This repository is primarily for personal practice, but feel free to fork it and use it for your own learning. If you have suggestions, open an issue!

## 📢 Stay Connected
   -   [GitHub](https://github.com/kokkondaBhanuteja)
   -   [LinkedIn](https://www.linkedin.com/in/kokkonda-bhanu-teja-73a7b7214/)
   -   [Email me](mailto:bhanutejakokkonda@gmail.com)


## Happy Coding! 🎯🚀

## Problem-1 (Ninja and Locker)
   ### Statement
   ```sh
   Ninja has two arrays ‘CASH’’ and ‘LOCKER’ denoting the height of each stack of cash of unit width and height of ‘N’ sections in the locker respectively.

   The locker sections are labeled from 0 to ‘N’ - 1 from left to right.

   Cash stacks can only be put in the locker by following the certain rules:

   Cash stacks can’t be piled up
   You can take any order of cash stack
   You can push the stack in the locker only from left to right
   If height of some stack is greater than the height of locker section then the stack will be stopped before that room
   Ninja wants your help to find the maximum number of cash stacks he can put into the locker.
   ```
   ![NINAJA_AND_LOCKER](./images/ninja_and_locker-1.png) 
   ![NINAJ_AND_LOCKER](./images/ninja_and_locker-2.png)
   
   ### [SOLUTION](./Solutions%20in%20JAVA/Ninja_And_Locker.java)


## Problem-2
   ### Statement
   ```sh
   Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.
Table: Address

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.


Write a SQL query for a report that provides the following 
information for each person in the Person table, regardless if there is an address for each of those people:

FirstName, LastName, City, State
   ```
   ### [SOLUTION](./SQL/combine-two-tables.sql)


## Problem-3
   ### Statement
   ```sh
   You are given a Binary Search Tree (BST) that contains positive integers only. 
   Your task is to find out whether the BST contains a Dead End. A BST is said to have a Dead End if there exists a leaf node in the BST,
   for which it is impossible to insert any further nodes after that node in that BST. If such nodes do not exist, then the BST doesn’t contain a Dead End.

   A binary search tree (BST), also called an ordered or sorted binary tree, is a rooted binary tree whose internal nodes 
   each store a value greater than all the values in the node's left subtree and less than those in its right subtree.
   ```
   ```sh
      Sample Input 1 :
         1
         10 6 12 2 8 11 15 -1 -1 -1 -1 -1 -1 -1 -1
         Sample Output 1 :
         True
   ```
   ![Problem_Image](./images/deadend_bst-1png.png)
   ### [SOLUTION](./Solutions%20in%20JAVA/CheckForDeadEnd_In_BST.java)


