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
  private links: Array<{ name: string, path: string }> = [
    { name: 'Catalogue', path: '/catalogue' },
    { name: 'Detail', path: '/detail' }
  ];

  
  

}
