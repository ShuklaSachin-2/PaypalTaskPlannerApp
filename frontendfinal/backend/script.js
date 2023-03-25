// Define an array to store sprints
let sprints = [];

// Function to add a sprint
function addSprint() {
	console.log("hello");
    let sprintName = document.getElementById("sprint-name").value;
    let sprint = {name: sprintName, tasks: []};

    // Send an AJAX request to the backend to create the sprint
    fetch('http://localhost:8888/addsprint', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(sprint)
    })
    .then(response => response.json())
    .then(data => {
        // Add the returned sprint to the sprints array
		console.log(data);
        sprints.push(data);

        // Add the sprint to the select dropdown
        let option = document.createElement("option");
        option.value = data.name;
        option.text = data.name;
        document.getElementById("sprint-select").add(option);

        // Clear the sprint form
        document.getElementById("sprint-name").value = "";

        // Show the sprint table
        document.getElementById("sprint-table").style.display = "block";
    })
    .catch(error => console.error(error));
}


// Function to add a sprint to the table
function addSprintToTable(sprint) {
	let table = document.getElementById("sprint-table");
	let row = table.insertRow(-1);
	let nameCell = row.insertCell(0);
	nameCell.innerHTML = sprint.name;
	let taskCell = row.insertCell(1);
	taskCell.innerHTML = "No tasks yet";
}

// Function to add a task to a sprint
function addTask() {
    let sprintName = document.getElementById("sprint-select").value;
    let title = document.getElementById("task-title").value;
    let description = document.getElementById("task-description").value;
    let taskType = document.getElementById("task-type").value;
    let taskStatus = document.getElementById("task-status").value;
    let assignedTo = document.getElementById("task-assigned-to").value;

    // Find the sprint in the sprints array
    let sprint = sprints.find(s => s.name === sprintName);

    // Create a task object with the input values
    let task = {title, description, taskType, taskStatus, assignedTo};

    // Send a POST request to the backend to add the task to the sprint
    fetch(`/api/sprints/${sprintName}/tasks`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(task)
    })
    .then(response => response.json())
    .then(data => {
        // Add the returned task to the sprint's tasks array
        sprint.tasks.push(data);

        // Clear the task form
        document.getElementById("task-title").value = "";
        document.getElementById("task-description").value = "";
        document.getElementById("task-type").value = "";
        document.getElementById("task-status").value = "";
        document.getElementById("task-assigned-to").value = "";

        // Add the task to the sprint table
        let table = document.getElementById("task-table-body");
        let row = table.insertRow(-1);
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);
        let cell3 = row.insertCell(2);
        let cell4 = row.insertCell(3);
        let cell5 = row.insertCell(4);
        cell1.innerHTML = data.title;
        cell2.innerHTML = data.description;
        cell3.innerHTML = data.taskType;
        cell4.innerHTML = data.taskStatus;
        cell5.innerHTML = data.assignedTo;
    })
    .catch(error => console.error(error));
}



// Function to add a task to the table
function addTaskToTable(sprintName, task) {
	let table = document.getElementById("sprint-table");
	for (let i = 1; i < table.rows.length; i++) {
		let row = table.rows[i];
		let nameCell = row.cells[0];
		if (nameCell.innerHTML === sprintName) {
			let taskCell = row.cells[1];
			if (taskCell.innerHTML === "No tasks yet") {
				taskCell.innerHTML = "";
			}
			taskCell.innerHTML += "<div class='task'><div>" + task.title + "</div><div>" + task.description + "</div><div>" + task.type + "</div><div>" + task.status + "</div></div>";
			break;
		}
	}
}
