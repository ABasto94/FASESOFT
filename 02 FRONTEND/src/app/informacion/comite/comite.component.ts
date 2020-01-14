import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@Component({
  selector: 'app-comite',
  templateUrl: './comite.component.html',
  styleUrls: ['./comite.component.css']
})
export class ComiteComponent implements OnInit {

  constructor() { }

  public pictures = [
    {
      src: "assets/img/superbox/superbox-thumb-1.jpg",
      img: "assets/img/superbox/superbox-full-1.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title:"Fredy Sandoval",correo: "asesofware@asesofware.com",
    },
    {
      src: "assets/img/superbox/superbox-thumb-2.jpg",
      img: "assets/img/superbox/superbox-full-2.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title:"Sandra Gonzales", correo:"sg@asesoftware.com",
    },

    {
      src: "assets/img/superbox/superbox-thumb-3.jpg",
      img: "assets/img/superbox/superbox-full-3.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-4.jpg",
      img: "assets/img/superbox/superbox-full-4.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-5.jpg",
      img: "assets/img/superbox/superbox-full-5.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Study Time",
    },
    {
      src: "assets/img/superbox/superbox-thumb-6.jpg",
      img: "assets/img/superbox/superbox-full-6.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme",
    },

    {
      src: "assets/img/superbox/superbox-thumb-7.jpg",
      img: "assets/img/superbox/superbox-full-7.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "New Styla",
    },

    {
      src: "assets/img/superbox/superbox-thumb-8.jpg",
      img: "assets/img/superbox/superbox-full-8.jpg",
      alt: "My first photoshop layer mask on a high end PSD template theme", title: "Cristpta",
    }
  ];


  ngOnInit() {
  }

}
