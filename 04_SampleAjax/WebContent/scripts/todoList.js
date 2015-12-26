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
	
	function createTask(tastTitle, tastDescription) {
		var task = {
				title: tastTitle,
				description: tastDescription
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
	
	function updateTask(taskId, tastTitle, tastDescription){
		var newTask = {
				title: tastTitle,
				description: tastDescription
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
		var title;
		var description;
		
		$(document).on("click", "#tasksList [data-task-id]", function() {
			taskId = $(this).attr("data-task-id");
			title = $(this).attr("data-task-title");
			description = $(this).attr("data-task-description");
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
			$("#updatePanel input[name='title']").val(title);
			$("#updatePanel textarea[name='description']").val(description);
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
			var title = $("#updatePanel input[name='title']").val();
			var description = $("#updatePanel textarea[name='description']").val();
			updateTask(taskId, title, description);
			showPanel("emptyPanel");
		});
	};
	
	attachHandlers();
	reloadTasks();
});
