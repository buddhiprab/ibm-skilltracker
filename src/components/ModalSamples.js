import React, { Component } from 'react' ;
import { Container , Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import SearchBar from "./SearchBar";
import frameworks from '../data/frameworks' ;
import languages from '../data/languages' ;
import dataStorage from '../data/dataStorage' ;
import practices from '../data/practices' ;
import platforms from '../data/platforms' ;
import CheckBox from "./CheckBox";
import names from "../data/names";
import{ Table }from "reactstrap";



class ModalSamples extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            modal: false
        };

        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState(prevState => ({
            modal: !prevState.modal
        }));
    }

    createTable(i) {
        let mapping = { 0:'platforms' , 1:'languages', 2:'tools' , 3:'frameworks',4:'practices' , 5:'dataStorage' } ;

        if (mapping[i] !== 'tools') {
            console.log(this.name) ;
            console.log(this.id) ;
            let array_to_iterate = mapping[i]  ;
            let out = []  ;
            if(array_to_iterate==='platforms'){
               out =  platforms.map(function(n){ return <CheckBox  details={n}/>}) ;
            }
            else if(array_to_iterate==='languages'){
                out = languages.map(function(n){return <CheckBox details={n}/>}) ;
            }
            else if(array_to_iterate==='practices'){
                out = practices.map(function(n){return <CheckBox details={n}/>}) ;
            }
            else{
                // out = dataStorage.map(function(n){return <CheckBox details={n}/>}) ;
                // dataStorage.map(n => (<CheckBox details={n}/>));
                out = dataStorage;
            }
            /*
            console.log(this.practices_arr.toString()) ;
            let rowCount = array_to_iterate.length % 4 === 0 ? array_to_iterate.length % 4 : ((array_to_iterate.length % 4) + 1);

            let table = [];
            let count = 0;

            for (let row = 0; row < rowCount; row++) {
                let children = [];

                for (let col = 0; col < 4; col++) {
                    children.push(<td><CheckBox name={array_to_iterate[count]} /></td>);
                    count += 1
                }
                table.push(<tr> {children}</tr>);
            }
            return table;
            */

            // let table = [] ;
            // out.map(function(k){
            //     table.push(<tr><CheckBox details={k}/></tr>) ;
            //
            // }) ;
            // out.map(item => (<tr><CheckBox details={item}/></tr>));

            return out ;
        }
    }



    render() {
        const size = {width: '100%'  , padding:'2% 5% 2% 5%' } ;
        let y = this.createTable(this.props.details.table_id) ;
        console.log(y)  ;
        return (
            <div className="container-fluid">
                <Button color="primary" onClick={this.toggle} style={size} className="btn-lg">{this.props.details.name}</Button>
                <Modal isOpen={this.state.modal} toggle={this.toggle} className="modal-xl" style={{width:'100%'}}>
                    <ModalHeader toggle={this.toggle} className="modal-header modal-xl" >{this.props.details.name}</ModalHeader>
                    <SearchBar/>
                    <ModalBody className="modal-body modal-dialog-scrollable modal-xl">
                        {console.log(this.props)}
                        <Table>
                            {y.map(item => <tr><CheckBox details={item}/></tr>)}
                        </Table>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="secondary" onClick={this.toggle}>CLOSE</Button>
                    </ModalFooter>
                </Modal>
            </div>
        );
    }
}

export default ModalSamples;