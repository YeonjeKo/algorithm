# Managers with at Least 5 Direct Reports

> Medium | 0570 | LeetCode

## Problem Overview

- Platform: LeetCode
- Difficulty: Medium
- Problem ID: 0570
- Tags: Database
- Problem Link: [https://leetcode.com/problems/managers-with-at-least-5-direct-reports/](https://leetcode.com/problems/managers-with-at-least-5-direct-reports/)

## Problem

<p>Table: <code>Employee</code></p>

<pre>
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| department  | varchar |
| managerId   | int     |
+-------------+---------+
id is the primary key (column with unique values) for this table.
Each row of this table indicates the name of an employee, their department, and the id of their manager.
If managerId is null, then the employee does not have a manager.
No employee will be the manager of themself.
</pre>

<p>&nbsp;</p>

<p>Write a solution to find managers with at least <strong>five direct reports</strong>.</p>

<p>Return the result table in <strong>any order</strong>.</p>

<p>The result format is in the following example.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> 
Employee table:
+-----+-------+------------+-----------+
| id  | name  | department | managerId |
+-----+-------+------------+-----------+
| 101 | John  | A          | null      |
| 102 | Dan   | A          | 101       |
| 103 | James | A          | 101       |
| 104 | Amy   | A          | 101       |
| 105 | Anne  | A          | 101       |
| 106 | Ron   | B          | 101       |
+-----+-------+------------+-----------+
<strong>Output:</strong> 
+------+
| name |
+------+
| John |
+------+
</pre>


## Submission

| Item | Value |
| --- | --- |
| Status | Accepted |
| Language | MySQL |
| Runtime | 355 ms (76.21%) |
| Memory | 0B (100.00%) |
| Submission ID | 2123422865 |

---

_Synced with AlgorithmHub_