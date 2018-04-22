import {Injectable} from '@angular/core';
import {Subject} from "rxjs/Subject";

@Injectable()
export class SharedService {
  user = null;
  userObservable = new Subject<any>();
  compareResult = null;
  strategy = null;

  setUser(u) {
    this.user = u;
    this.userObservable.next(u);
  }

  clearUser() {
    this.user = null;
    this.userObservable.next(null);
  }
}
