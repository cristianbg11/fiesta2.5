<%--
  Created by IntelliJ IDEA.
  User: Crist
  Date: 8/25/2020
  Time: 2:36 PM
--%>

<main class="page service-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Estadisticas</h2>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-4">
                        <div></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<div id="container" style="width: 75%;">
<canvas id="canvas"></canvas>
</div>
<script>

var config = {
type: 'pie',
data: {
datasets: [{
data: [
${pendientes},
${realizadas},
${compras}
],
backgroundColor: [
'red',
'orange',
'green'
],

}],
labels: [
'Pendientes',
'Realizadas',
'Compras'
]
},
options: {
responsive: true
}
};
window.onload = function() {
var ctx = document.getElementById('canvas').getContext('2d');
window.myPie = new Chart(ctx, config);

};
</script>
