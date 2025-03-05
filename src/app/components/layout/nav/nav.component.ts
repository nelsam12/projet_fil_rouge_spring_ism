import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-nav',
  imports: [RouterModule],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent {
  private title: string | null = null;

  protected links: Link[] = [
    { name: 'Catalogue', path: '/catalogue', class:"nav-link", ariaCurrent: 'page'},
  ];

  // constructor() {
  //   this.title = 'Angular 2 App';
  // }
}

interface Link {
  name: string;
  path: string;
  class : string; // Optionnel
  subLinks?: Array<Link>; // Optionnel
  ariaCurrent?: string; // Optionnel
}
