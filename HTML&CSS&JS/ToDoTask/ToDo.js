var id = 1;
var tasks = [];
tasks.push({ TaskId: "Task0", TaskName: "Add new tasks" });

function showForm() {
    let form = document.querySelector(".main-container_task-form");
    form.classList.remove("hide");
    form.classList.add("show");
}

function hideForm() {
    let form = document.querySelector(".main-container_task-form");
    form.classList.remove("show");
    form.classList.add("hide");
}

function handleClick(event) {
    if (event.target.type == "checkbox") {
        let ele = document.querySelector(".lbl" + event.target.id);
        ele.classList.toggle("task-done");
    }
    if (event.target.tagName == "A") {
        deleteTask(event.target.id);
    }
}

function deleteTask(taskid) {
    let divId = taskid.substring(3);
    for (let currTask of tasks) {
        if (currTask.TaskId == divId) {
            tasks.splice(tasks.indexOf(currTask), 1);
            console.log("Removed from tasks");
        }
    }
    let delElement = document.querySelector("." + divId);
    delElement.remove();
}

function addTask() {
    let form = document.forms.task;
    console.log(form.elements.taskName.value);
    let task = { TaskId: "Task" + id, TaskName: form.elements.taskName.value };
    tasks.push(task);
    hideForm();
    renderTasks();
}

function renderTasks() {
    for (let currTask of tasks) {
        if (document.querySelector("." + currTask.TaskId) == null) {
            let tasksDIV = document.querySelector(".main-container_all-tasks");
            let checkbox = `<input type="checkbox" id= ${currTask.TaskId} />`;
            let label = document.createElement("label");
            label.setAttribute("for", "Task" + currTask.TaskId);
            label.textContent = currTask.TaskName;
            label.classList.add("lbl" + currTask.TaskId);
            let delLink = document.createElement("a");
            delLink.id = "del" + currTask.TaskId;
            delLink.href = "#";
            delLink.classList.add("del" + currTask.TaskId);
            delLink.textContent = "Delete Task";
            let task = document.createElement("div");
            task.innerHTML = checkbox;
            task.append(label);
            task.append(delLink);
            task.classList.add(currTask.TaskId);
            tasksDIV.append(task);
            id++;
            console.log("Added tasks");
        }
    }
}

function init() {
    renderTasks();
}