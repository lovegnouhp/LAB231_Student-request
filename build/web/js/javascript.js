/*
 * Copyright(C) 2021,  FPT University
 * J3.L.P0010 Student Request System - admin site
 * Record of change:
 * DATE            Version          AUTHOR                DESCRIPTION
 * 2021-07-04      1.0              PhuongNVHE140784      Initial commit
 */

/**
 * get today date & display on navigation pane
 */
function getDateToday() {
    var weekdays = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    var d = new Date();
    var date = d.getDate();
    var month = d.getMonth() + 1;
    var year = d.getFullYear();
    var today = weekdays[d.getDay()] + " "
            + (date < 10 ? "0" : "") + date + "/"
            + (month < 10 ? "0" : "") + month + "/" + year;
    document.getElementById("today").innerHTML = today;
}

/**
 * fill input fields when user solve request.
 */
function setRequestState() {
    var d = new Date();
    var date = d.getDate();
    var month = d.getMonth() + 1;
    document.getElementById("close_date").value = (month < 10 ? "0" : "") + month + "/"
            + (date < 10 ? "0" : "") + date + "/" + d.getFullYear();
    document.getElementById("solved_by").value = document.getElementById("username").value;
    document.getElementById("save_btn").disabled = false;
}