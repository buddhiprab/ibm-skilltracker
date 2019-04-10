import React, { Component } from 'react' ;
import { Form , Label ,Input , Button} from 'reactstrap' ;
import FormGroup from "reactstrap/es/FormGroup";
import {Table} from 'reactstrap' ;

class SearchBar extends Component{
    constructor(props){super(props) ;}
    render(){

        return(
            <Table>
            <tr>
            <Form>
                <FormGroup style={{display: 'inline-block'}}>

                        <th><Input type="text" name="search" id="search" placeholder="Search" className="float-right" display={{width:'80%'}} /></th>
                        <th><Button className="btn-md float-left" color="secondary" display={{width:'20%'}} > Search</Button></th>


                </FormGroup>
            </Form>
            </tr>
            </Table>

        ) ;
    }
}

export default SearchBar ;