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
        // document.getElementById("sprint-select").add(option);

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
    // Get form input values
    const sprintId = document.getElementById("sprint-select").value;
    const title = document.getElementById("task-title").value;
    const description = document.getElementById("task-desc").value;
    const type = document.getElementById("task-type").value;
    const status = document.getElementById("task-status").value;
    const assignedTo = document.getElementById("task-assigned-to").value; // Read assigned-to value

    // Create new task object
    const task = {
        sprintId: sprintId,
        title: title,
        description: description,
        type: type,
        status: status,
        assignedTo: assignedTo // Assign assignedTo value
    };

    // Send task data to backend
    fetch("http://localhost:8888/addtask/${sprintId}/${assignedTo}", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
			
        },
        body: JSON.stringify(task)
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        // Add task to sprint table
		 // Add task to sprint table
		 const sprintTableBody = document.getElementById(`sprint-table-body`);
		 console.log(sprintTableBody);
		 const newRow = sprintTableBody.insertRow(-1);
		 const cell1 = newRow.insertCell(0);
		 const cell2 = newRow.insertCell(1);
		 const cell3 = newRow.insertCell(2);
		 const cell4 = newRow.insertCell(3);
		 const cell5 = newRow.insertCell(4);
		 const cell6 = newRow.insertCell(5);
		 cell1.innerHTML = sprintId;
		 cell2.innerHTML = title;
		 cell3.innerHTML = description;
		 
		
		 cell4.innerHTML = type === 'STORY' ? 'Story' : type === 'BUG' ? 'Bug' : 'Feature';
cell5.innerHTML = status === 'NEW' ? 'New' : status === 'IN_PROGRESS' ? 'In Progress' : 'Done';

		 cell6.innerHTML = assignedTo;
		//  cell7.innerHTML = `<button onclick="deleteTask(${data.id})">Delete</button>`;
        
    })
    .catch(error => console.log(error));

	

	 

	
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
