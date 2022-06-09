import {Component, Input, OnInit} from '@angular/core';
import {MenuItem} from "../../app.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-breadcrumb',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.css']
})
export class BreadcrumbComponent implements OnInit {
  @Input() items: MenuItem[] = [];
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  isLinkActive(url : string): boolean {
    const queryParamsIndex = this.router.url.indexOf('?');
    const baseUrl = queryParamsIndex === -1 ? this.router.url :
      this.router.url.slice(0, queryParamsIndex);
    return baseUrl === url;
  }


}
