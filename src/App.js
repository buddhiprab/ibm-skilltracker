import React, { Component } from 'react'
import './App.css';
import './components/Dropdown'
import frameworks from './data/frameworks' ;
import languages from './data/languages' ;
import dataStorage from './data/dataStorage' ;
import practices from './data/practices' ;
import platforms from './data/platforms' ;
//import { MDBDataTable } from 'mdbreact';
import { Collapse, Button, CardBody, Card } from 'reactstrap';

import SearchBar from "./components/SearchBar" ;
import ModalSamples from "./components/ModalSamples" ;
import names from "./data/names" ;
import { Container , Modal, ModalHeader, ModalBody, ModalFooter  } from 'reactstrap';
import CheckBox from "./components/CheckBox" ;
import Table from "reactstrap/es/Table";
import Input from "reactstrap/es/Input";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            modal: false
        };
        this.toggle = this.toggle.bind(this);
        //this.deleteRow = this.deleteRow.bind(this) ;
        this.toggleCollapse = this.toggleCollapse.bind(this) ;


    }

    toggle() {
        this.setState(prevState => ({
            modal: !prevState.modal
        }));
    }

    toggleCollapse(){
        this.setState(prevState =>({ collapse: !prevState.collapse})) ;
    }

    createTable(){
        let finalArray = [] ;
        let p = platforms.map(function(n){ return {n}}) ;
        let l = languages.map(function(n){ return {n}}) ;
        let bd= dataStorage.map(function(n){ return{n}}) ;
        let pr= practices.map(function(n){ return {n}}) ;
        finalArray[0] = p ;
        finalArray[1] = l ;
        finalArray[2] = bd ;
        finalArray[3] = pr;

        return finalArray ;
    }


  render() {
      const tabs  = names.map(function(n){ return <div><br /><div key={n.id}><ModalSamples  details={n}/></div><br /></div>}) ;

      let counter = 0 ;

      const finalArr = this.createTable();
      const finalPlat= finalArr[0].map(function(n){return <tr key={ n.id}>
          <td><Button>Edit</Button> </td>
          <td>{n.name}</td>

          <td>0</td>
          <td>Used at Work</td>
          <td>NO</td>
          <td><Button className="btn-sm btn-danger"> X </Button></td>
      </tr>}) ;

      counter += finalPlat.length ;


      const finalLang= finalArr[1].map(function(n){
          return <tr key={n.id }  id={ counter} >
          <td><Button>Edit</Button> </td>
          <td>{  n.name}</td>
          <td>0</td>
          <td>Used at Work</td>
          <td>NO</td>
          <td><Button className="btn-sm btn-danger"  id={n.id} > X </Button></td>
      </tr>}) ;

      counter += finalLang.length ;

      const finalData= finalArr[2].map(function(n){return <tr key={n.id }  id={counter}>
          <td><Button>Edit</Button> </td>

          <td>{n.name}</td>
          <td>0</td>
          <td>Used at Work</td>
          <td>NO</td>
          <td><Button className="btn-sm btn-danger"> X </Button></td>
      </tr>}) ;

      counter+= finalData.length ;

      const finalPractices= finalArr[3].map(function(n){return <tr key={n.id } id={n.id }>
          <td><Button>Edit</Button> </td>
          <td>{n.name }/</td>
          <td>0</td>
          <td>Used at Work</td>
          <td>NO</td>
          <td><Button className="btn-sm btn-danger"> X </Button></td>
      </tr>}) ;

      console.log(finalArr[0]) ;



      return(
        <Container style={{width:'100%'}}>
            <Container style={{width:'100%' , padding:'0% 0% 0% 0%' , margin:'0% 0% 0% 0%'}} className="container-fluid">
                <div style={{margin:'2% 0% 0% 2%' , padding:'1% 0% 0% 1%'}}>
                    <br/>
                     <h3 className="float-left text-center" style={{margin:'0% 0% 0% -2%'}}>Skill Sets</h3>

                    <Button color="danger" onClick={this.toggle} className="float-lg-right text-capitalize text-center" style={{margin:'0% 1.4% 0% 0%'}}>My Summary</Button>
                    <br/>
                    <Modal isOpen={this.state.modal} toggle={this.toggle} className="modal-xl" style={{width:'100%'}}>
                    <ModalHeader toggle={this.toggle} className="modal-header modal-xl" style={{width:'100%'}} >My Summary</ModalHeader>
                        <SearchBar/>
                        <ModalBody className="modal-body modal-dialog-scrollable modal-xl" style={{width:'100%'}}>
                           <Table className="table table-bordered table-striped mb-0" id="myTable">
                               <thead>
                               <tr>
                                   <th> </th>
                                   <th>Skill </th>
                                   <th>Years of Experience</th>
                                   <th>Proficiency</th>
                                   <th>Certification</th>
                                   <th> </th>
                               </tr>
                               </thead>
                               <tbody>
                               {finalPlat}
                               {finalLang}
                               {finalData}
                               {finalPractices}
                               </tbody>
                           </Table>

                        </ModalBody>
                        <ModalFooter>
                    <Button color="secondary" onClick={this.toggle}>CLOSE</Button>
                    </ModalFooter>
                    </Modal>

                </div>

            </Container>

            {tabs}
        </Container>

    ) ;
  }
}

export default App;
