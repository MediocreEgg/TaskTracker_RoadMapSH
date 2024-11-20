# [Task Tracker](https://roadmap.sh/projects/task-tracker) by [RoadMap](https://roadmap.sh/)

## Description
>Task tracker is a project used to track and manage your tasks. In this task, you will build a simple command line interface (CLI) to track what you need to do, what you have done, and what you are currently working on. This project will help you practice your programming skills, including working with the filesystem, handling user inputs, and building a simple CLI application.

Click here for **[[#Documentation]]**.

# Requirements
The application should run from the command line, accept user actions and inputs as arguments, and store the tasks in a JSON file. The user should be able to:

- [x] Add, Update, and Delete tasks ✅ 2024-11-20
- [ ] Mark a task as in progress or done
- [ ] List all tasks
- [ ] List all tasks that are done
- [ ] List all tasks that are not done
- [ ] List all tasks that are in progress
- [ ] Here are some constraints to guide the implementation:
## Constraints:
- [x] ~~You can use any programming language to build this project.~~  (JAVA ☕🔴) ✅ 2024-11-20
- [x] ~~Use positional arguments in command line to accept user inputs.~~ ✅ 2024-11-20
- [ ] Use a JSON file to store the tasks in the current directory.
- [ ] The JSON file should be created if it does not exist.
- [ ] Use the native file system module of your programming language to interact with the JSON file.
- [ ] Do not use any external libraries or frameworks to build this project.
- [ ] Ensure to handle errors and edge cases gracefully.


# Functionality Progress
>This section are apart from the following statements mentioned above:

> [!todo]+ Task Command 
>- [x]  [[#Task Function]]
>	- [x] Constraints
>	- [ ] Handling Error
> 
>- [x] ADD Argument
>	- [ ] Constraints
>	- [ ] Handling Error
>
>- [x] DELETE Argument
>	- [ ] Constraints
>	- [ ] Handling Error
>
>- [x] UPDATE Argument 
>	- [ ] Constraints
>	- [x] Handling Error
>

> [!todo] List Command
>- [ ] List Function
>- [ ] Tasks Function
>- [ ] DONE
>- [ ] NOTDONE
>- [ ] INPROGRESS


# DOCUMENTATION
---
## Plain Old Java Object - STRUCTURE
```Java
TASK:: [ID=# | NAME="..." | DATE="MMMM DD, YYYY" | STATUS=[DONE | NOTDONE | INPROGRESS]]
```

| **Data Type** | <center>**Name**</center> | <center>Default Value</center> |
| ------------- | ------------------------- | ------------------------------ |
| Long          | *id*                      | <center><i>N/A*</i></center>   |
| String        | *taskName*                | <center>*Prompt*~</center>     |
| String        | *date*                    | <center><i>N/A*</i></center>   |
| TaskStatus    | *status*                  | <center>NOTDONE</center>       |
 ### Legend/s:
* *\**  automatically produce/given by the application
--- 
## API
> Note:
>  • Anything within *brackets* **[ ]** are **optional** and whereas, *angle brackets* **{ }** are **required**.
>  • For argument that requires String input, use double quotation marks ("") for long phrases. Otherwise, for single word/character it may disregard.

> [!info]+ TASK
> ```CLI
> Task < [-ArgumentList] < [ String[] | Integer ] > >
> ```
>> [!info]+ ArgumentList
>> 
>>> [!info]- -add
>>> ```Java
>>> Task -add NAME=<String[]> [STATUS=< DONE  |  NOTDONE  |  INPROGRESS >]
>>>```
>>>
>>>>[!example] Example/s:
>>>>```Java
>>>> Task -add NAME=Code  
>>>> Task -add NAME="Code More" 
>>>> Task -add NAME=Code STATUS=INPROGRESS
>>>> 
>>>> //AFTER:
>>>> // TASK:: [ID=1 | NAME=Code | DATE=January 01, 2025 | STATUS=NOTDONE]
>>>> // TASK:: [ID=2 | NAME=Code More | DATE=February 13, 2025 | STATUS=NOTDONE]
>>>> // TASK:: [ID=3 | NAME=Code | DATE=March 15, 2025 | STATUS=INPROGRESS]
>>>> ```
>>
>>> [!info]- -delete 
>>> ```Java
>>> Task -delete < Positive Integer UID >
>>>```
>>>
>>>>[!example] Example/s:
>>>> ```Java
>>>> // BEFORE:
>>>> // TASK:: [ID=1 | NAME=Coding | DATE=Februray 20, 2025 | STATUS=INPROGRESS]
>>>> // TASK:: [ID=2 | NAME=Sleep | DATE=March 25, 2025 | STATUS=NOTDONE]
>>>> 
>>>> Task -delete 1
>>>> 
>>>> //AFTER:
>>>> // TASK:: [ID=2 | NAME=Sleep | DATE=March 25, 2025 | STATUS=NOTDONE]
>>>>```
>> 
>>> [!info]- -update
>>> ```Java
>>> Task -update < Integer > [NAME =<String[]>] [STATUS=< DONE  |  NOTDONE  |  INPROGRESS >]
>>>```
>>>
>>>>[!example] Example/s:
>>>>```Java
>>>> // BEFORE:
>>>> // TASK:: [ID=1 | NAME=Coding | DATE=Februray 20, 2025 | STATUS=INPROGRESS]
>>>> // TASK:: [ID=2 | NAME=Sleep | DATE=March 25, 2025 | STATUS=NOTDONE]
>>>> 
>>>> Task -update 1 NAME=Eating STATUS=DONE
>>>> Task -update 2 STATUS=INPROGRESS
>>>> 
>>>> // AFTER:
>>>> // TASK:: [ID=1 | NAME=Coding | DATE=Februray 20, 2025 | STATUS=DONE]
>>>> // TASK:: [ID=2 | NAME=Sleep | DATE=March 25, 2025 | STATUS=INPROGRESS]
>>>> ```
>>

