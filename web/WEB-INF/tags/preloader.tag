<%@ tag language="java" pageEncoding="UTF-8"%>

<script src="js/jquery-3.6.0.min.js"></script>
<script>
    $(window).on('load', function() { // makes sure the whole site is loaded
        $('#status').fadeOut(); // will first fade out the loading animation
        $('#preloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.
        $('body').delay(350).css({'overflow' : 'visible'});
    })
</script>

</head>
<body>
<div id="preloader">
    <div id="status">&nbsp;</div>
</div>