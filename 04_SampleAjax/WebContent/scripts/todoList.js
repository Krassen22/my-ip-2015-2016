$(document).ready(function() {
	"use strict";
	var ENDPOINT = "http://localhost:3000/tasks";
	function taskEndpoint(taskId) {
		return ENDPOINT + "/" + taskId;
	}

	function showPanel(panelName) {
		var ALL_PANELS = ["emptyPanel", "readPanel", "updatePanel", "createPanel"];
		_.forEach(ALL_PANELS, function(nextValue) {
			$("#"+nextValue).hide();
		});
		$("#"+panelName).fadeIn();
	}

	function listTasks() {
		return $.ajax(ENDPOINT, {
			method: "GET",
			dataType: "json"
		});
	}
	
	function readTask(taskId) {
		return $.ajax(taskEndpoint(taskId), {
			method: "GET",
			dataType: "json"
		});
	}
	
	function showTaskView(task) {
		$("#readPanel .task-title").text(task.title);
		$("#readPanel .task-description").text(task.description);
		showPanel("readPanel");
	}
	
	function reloadTasks() {
		listTasks().then(function(response) {
			function addTaskToList(task) {
				var newItem = $("<li />");
				newItem.text(task.title);
				newItem.addClass("list-group-item");
				newItem.attr("data-task-id", task.id);
				newItem.attr("data-task-title", task.title);
				newItem.attr("data-task-description", task.description);
				$("#tasksList").append(newItem);
			}
			$("#tasksList").html("");
			_.forEach(response, addTaskToList);
		});
	}
	
	function createTask(taskTitle, taskDescription) {
		var task = {
				title: taskTitle,
				description: taskDescription
		};
		$.ajax(ENDPOINT, {
			method: "POST",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(task),
			dataType: "json"
		}).then(function() {
			reloadTasks();
		});
	}
	
	function updateTask(taskId, taskTitle, taskDescription){
		var newTask = {
				title: taskTitle,
				description: taskDescription
		};
		$.ajax(taskEndpoint(taskId), {
			method: "PUT",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(newTask),
			dataType: "json"
		}).then(function() {
			reloadTasks();
		});
	}
	
	function deleteTask(taskId) {
		$.ajax(taskEndpoint(taskId), {
			method: "DELETE"
		}).then(function(){
			reloadTasks();
		})
	};
	
	function attachHandlers() {
		
		var taskId;
		var taskTitle;
		var taskDescription;
		
		$(document).on("click", "#tasksList [data-task-id]", function() {
			taskId = $(this).attr("data-task-id");
			taskTitle = $(this).attr("data-task-title");
			taskDescription = $(this).attr("data-task-description");
			readTask(taskId).then(showTaskView);
		});
		
		$(document).on("click", ".task-action-cancel", function() {
			showPanel("emptyPanel");
		});
		
		$(document).on("click", "#addTaskButton", function() {
			showPanel("createPanel");
		});
		
		$(document).on("click", "#readPanel .task-action-ok", function() {
			showPanel("updatePanel");
			$("#updatePanel input[name='title']").val(taskTitle);
			$("#updatePanel textarea[name='description']").val(taskDescription);
		});
		
		$(document).on("click", "#readPanel .task-action-remove", function() {
			deleteTask(taskId);
			showPanel("emptyPanel");
		});
		
		$(document).on("click", "#createPanel .task-action-ok", function() {
			var title = $("#createPanel input[name='title']").val();
			var description = $("#createPanel textarea[name='description']").val();
			createTask(title, description);
			$("#createPanel input[name='title']").val("");
			$("#createPanel textarea[name='description']").val("");
			showPanel("emptyPanel");
		});
		
		$(document).on("click", "#updatePanel .task-action-ok", function() {
			var newTitle = $("#updatePanel input[name='title']").val();
			var newDescription = $("#updatePanel textarea[name='description']").val();
			updateTask(taskId, newTitle, newDescription);
			showPanel("emptyPanel");
		});
	};
	
	attachHandlers();
	reloadTasks();
});
