$(document).ready(function() {
    $("menu [href]").each(function() {
    if (this.href == window.location.href) {
        $(this).addClass("current");
        }
    });
});