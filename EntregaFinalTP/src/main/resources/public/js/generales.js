/*<script src="https://cdn.jsdelivr.net/npm/vue@2"></script>

<script>

    const app = new Vue({
        el: '#app',
        data: {
        lista: ["1", "2"]
        },
        methods: {

    }

    });
</script>*/

document.addEventListener("DOMContentLoaded", function () {
    const carrusel = document.querySelector(".carrusel");
    const slides = document.querySelector(".slides");
    const slideList = document.querySelectorAll(".slide");

    let currentIndex = 0;

    function updateSlide() {
        slides.style.transform = `translateX(${-currentIndex * 100}%)`;
    }

    function nextSlide() {
        currentIndex = (currentIndex + 1) % slideList.length;
        updateSlide();
    }

    function prevSlide() {
        currentIndex = (currentIndex - 1 + slideList.length) % slideList.length;
        updateSlide();
    }

    setInterval(nextSlide, 3000); // Cambia de slide cada 3 segundos (ajusta según sea necesario)
});