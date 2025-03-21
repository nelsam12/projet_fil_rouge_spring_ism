import { Component } from '@angular/core';
import {FooterComponent} from './components/layout/footer/footer.component';
import {HeaderComponent} from './components/layout/header/header.component';
import {NavComponent} from '../../shared/components/nav/nav.component';
import {RouterOutlet} from '@angular/router';

@Component({
  selector: 'ism-catalogue',
  imports: [
    FooterComponent,
    HeaderComponent,
    NavComponent,
    RouterOutlet
  ],
  templateUrl: './catalogue.component.html',
  styleUrl: './catalogue.component.css'
})
export class CatalogueComponent {

}
