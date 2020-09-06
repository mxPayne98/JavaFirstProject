$(document).ready(function () {
    $("#result").hide();
    $("#inputs").hide();
    $("#nlp").hide();
    $("#single-date").hide();
    $("#double-date").hide();
    $("#numberofx").hide();
    $('#operation').on('change', function () {
        $("#nlp").hide();
        $("#single-date").hide();
        $("#double-date").hide();
        $("#numberofx").hide();
        if (this.value == 11) {
            $("#inputs").show();
            $("#nlp").show();
        } else if (this.value == 1 || this.value == 2) {
            $("#inputs").show();
            $("#double-date").show();
        } else if (this.value == 10 || this.value == 9) {
            $("#inputs").show();
            $("#single-date").show();
        } else if (this.value >= 3 && this.value <= 8) {
            $("#inputs").show();
            $("#single-date").show();
            $("#numberofx").show();
        }
    });

    $('#submit').on('click', () => {
        $("#result").show();
    });
});