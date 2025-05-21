# Task Manager CLI 🧩

A simple command-line task manager system built in Java using 5 core design patterns as part of a final project.

## 🎯 Project Goal

The goal is to simulate a real-world task management system (like Jira or Trello) where tasks can be created, assigned, and tracked — all using a clean console interface.  
It demonstrates the application of object-oriented principles and multiple design patterns.

---

## 🧠 Design Patterns Used

- **Command** – encapsulates user actions (`create`, `assign`, `update`, `list`)
- **Factory Method** – used to create different types of tasks (normal / urgent)
- **Singleton** – ensures only one instance of `TaskManager` exists
- **Observer** – notifies users when the task status is changed
- **State** – manages task states (`New`, `In Progress`, `Completed`) with different behaviors

---

## 🖥️ Features

- Create tasks via CLI
- Assign users to tasks
- Change task statuses
- See all current tasks and their status
- Console-based interaction

---

## 🧪 Sample Commands

