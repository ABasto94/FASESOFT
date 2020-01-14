import { Component, OnInit, OnDestroy, EventEmitter, Input, Output } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UriProvider } from '../../service/uri.provider';
import { UriControl } from '../../domain/generic.domain';
import { AdvancedSearch, SearchRule, SearchOperator, SearchRow } from '../../domain/generic.domain';
import { Field} from '../../domain/generic.domain';

/**
  * @author      gbuchely@asesoftware.com
  * @description Descriptions about component here ... 
  */
@Component({
  selector: 'generic-search',
  templateUrl: './generic-search.component.html'
})
export class GenericSearchComponent implements OnInit {
  private sub: any;
  private advancedSearch: AdvancedSearch;
  private filterBySearchList: SearchRow[];
  private orderBySearchList: SearchRow[];
  private fromValue: SearchRow = null;
  private toValue: SearchRow = null;
  @Input() fieldList: Field[];
  @Output() queryParamList = new EventEmitter<[string, string][]>();

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private uriProvider: UriProvider
    ) {
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  ngOnInit(): void {
    this.createSearchArguments();
    this.createSearchElement();
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  ngOnDestroy(): void {
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  createSearchArguments() {
    let filterByCommands : SearchOperator[] = new Array<SearchOperator>();
    filterByCommands.push(new SearchOperator('=', 'Igual a', '=', 'string'));
    filterByCommands.push(new SearchOperator('=', 'Igual a', '=', 'number'));
    filterByCommands.push(new SearchOperator('>', 'Mayor que', '>', 'number'));
    filterByCommands.push(new SearchOperator('<', 'Menor que', '<', 'number'));
    filterByCommands.push(new SearchOperator('>=', 'Mayor o igual que', '>=', 'number'));
    filterByCommands.push(new SearchOperator('<=', 'Menor o igual que', '<=', 'number'));
    filterByCommands.push(new SearchOperator('Not Like', 'No contiene',  ':NOTLIKE:', 'string'));
    filterByCommands.push(new SearchOperator('Like', 'Contiene', ':LIKE:', 'string'));
    let filterByRule = new SearchRule('FilterBy', 'Filtrado por', '&', filterByCommands);
    let orderByCommands : SearchOperator[] = new Array<SearchOperator>();
    orderByCommands.push(new SearchOperator('ASC', 'Ascendentemente', '$ASC', 'string'));
    orderByCommands.push(new SearchOperator('DESC', 'Descendentemente', '$DESC', 'string'));
    orderByCommands.push(new SearchOperator('ASC', 'Ascendentemente', '$ASC', 'number'));
    orderByCommands.push(new SearchOperator('DESC', 'Descendentemente', '$DESC', 'number'));
    let orderByRule = new SearchRule('OrderBy', 'Ordenado por', '&', orderByCommands);
    let rangeCommands : SearchOperator[] = new Array<SearchOperator>();
    rangeCommands.push(new SearchOperator('=', 'Igual a', '=', 'number'));
    let rangeRule = new SearchRule('RangeBy', 'Rango en', '&', rangeCommands);
    this.advancedSearch = new AdvancedSearch(filterByRule, orderByRule, rangeRule);
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  createSearchElement() {
    this.filterBySearchList = new Array<SearchRow>();
    this.orderBySearchList = new Array<SearchRow>();
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  addFilterByElement() {
    this.filterBySearchList.push(
      new SearchRow('filterBy', false, '', '', '', '', '', false, 'Not validated'));
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  addOrderByElement() {
    this.orderBySearchList.push(
      new SearchRow('orderBy', false, '', '', '', '', '', false, 'Not validated'));
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  addFromToElement() {
      this.fromValue =
        new SearchRow('rangeBy', false, 'from', '=', '', '', '', false, 'Not validated');
      this.toValue =
        new SearchRow('rangeBy', false, 'to', '=', '', '', '', false, 'Not validated');
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  deleteFilterByElement(filter: SearchRow) {
    this.filterBySearchList.splice(this.filterBySearchList.indexOf(filter), 1);
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  deleteOrderByElement(filter: SearchRow) {
    this.orderBySearchList.splice(this.orderBySearchList.indexOf(filter), 1);
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  deleteFromToByElement(filter: SearchRow) {
    this.fromValue = null;
    this.toValue = null;
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  saveSearch() {
    let separator : string = this.advancedSearch.filterByRule.separator;
    let searchArray : [string, string][] = new Array<[string, string]>();
    if (this.filterBySearchList !== null && this.filterBySearchList.length > 0) {
      let querySentence : string = '';
      for (let filterRow of this.filterBySearchList) {
         if (filterRow.validation) {
           if (querySentence.length > 0) {
             querySentence = querySentence + separator + filterRow.sentence;
           } else {
             querySentence = filterRow.sentence;
           }
         }
      }
      searchArray.push(['filterBy', querySentence]);
    }
    separator = this.advancedSearch.orderByRule.separator;
    if (this.orderBySearchList !== null && this.orderBySearchList.length > 0) {
      let querySentence : string = '';
      for (let filterRow of this.orderBySearchList) {
         if (filterRow.validation) {
           if (querySentence.length > 0) {
             querySentence = querySentence + separator + filterRow.sentence;
           } else {
             querySentence = filterRow.sentence;
           }
         }
      }
      searchArray.push(['orderBy', querySentence]);
    }
    separator = this.advancedSearch.rangeRule.separator;
    let querySentence : string = '';
    if (this.fromValue !== null && this.fromValue.validation &&
        this.toValue !== null && this.toValue.validation) {
        querySentence = this.fromValue.field + this.fromValue.operator + this.fromValue.value + separator +
                        this.toValue.field + this.toValue.operator + this.toValue.value;
        searchArray.push([this.fromValue.field, this.fromValue.value]);
        searchArray.push([this.toValue.field, this.toValue.value]);
    }
    this.queryParamList.emit(searchArray);
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  getOperatorList(fieldName : string, inputValue: SearchRow) : SearchOperator[] {
    let operatorList : SearchOperator[];
    let fieldType = this.getFieldType(fieldName);
    if (fieldName !== null && fieldName.length > 0) {
      switch ( inputValue.rule ) {
        case 'filterBy':
          operatorList = this.advancedSearch.filterByRule.commands.filter(function (element) {
              return ((element.type ? element.type.startsWith(fieldType) : null));
          });
          break;
        case 'orderBy':
          operatorList = this.advancedSearch.orderByRule.commands.filter(function (element) {
              return ((element.type ? element.type.startsWith(fieldType) : null));
          });
          inputValue.validation = true;
          inputValue.validationComment = 'Valid';
          inputValue.sentence = inputValue.field + inputValue.operator;
          break;
        case 'rangeBy':
          operatorList = this.advancedSearch.filterByRule.commands.filter(function (element) {
              return ((element.type ? element.type.startsWith(fieldType) : null));
          });
          break;
        default:
      }
    }
    this.validateSearchRow(inputValue);
    return operatorList;
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  getFieldType(fieldName : string) : string {
    let columnList = this.fieldList.filter(function (element) {
        return ((element.name ? element.name.startsWith(fieldName) : null));
    });
    return columnList[0].type;
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  onInputKey(inputValue: SearchRow) {
    this.validateSearchRow(inputValue);
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  validateSearchRow(inputValue: SearchRow) {
    let validation : string = '';
    let numberValidation = '^([0-9]*)$';
    let stringValidation = '^([0-9A-Za-z ]*)$';
    switch (this.getFieldType(inputValue.field)) {
        case 'number':
          validation = numberValidation;
          break;
        case 'string':
          validation = stringValidation;
          break;
        default :
          validation = stringValidation;
    }
    let trigger = inputValue.value,
      regexp = new RegExp(validation),
      state = regexp.test(trigger);
    inputValue.validation = state;
    if (state) {
      inputValue.validationComment = 'Valid';
      inputValue.sentence = inputValue.field + inputValue.operator + inputValue.value;
    } else {
      inputValue.validationComment = 'Invalid';
    }
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  onFromValueKey(fromValue: SearchRow) {
    let validation : string = '^([0-9]*)$';
    let trigger = fromValue.value,
      regexp = new RegExp(validation),
      state = regexp.test(trigger);
    fromValue.validation = state;
    if (state) {
      fromValue.validationComment = 'Valid';
      fromValue.sentence = fromValue.field + fromValue.operator + fromValue.value;
    } else {
      fromValue.validationComment = 'Invalid';
    }
  }
 /**
   * @description Descriptions about method here ... 
   * @param       Descriptions about input value here ...
   * @return      Descriptions about response value here ...
   */
  onToValueKey(toValue: SearchRow) {
    let validation : string = '^([0-9]*)$';
    let trigger = toValue.value,
      regexp = new RegExp(validation),
      state = regexp.test(trigger);
    if (state) {
      if (+toValue.value < +this.fromValue.value) {
        state = false;
      }
    }
    toValue.validation = state;
    if (state) {
      toValue.validationComment = 'Valid';
      toValue.sentence = toValue.field + toValue.operator + toValue.value;
    } else {
      toValue.validationComment = 'Invalid';
    }
  }
}