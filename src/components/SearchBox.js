import React , {Component} from 'react' ;
import ReactDOM from 'react-dom' ;

class SearchBox extends Component{
    constructor(props){
        super(props) ;
        //this.search = this.search(this)
    }
    //search(){ return 0 ; }
    render() {
        return(
            <div className="search" >
                <span>
                <input type="text" className="float-left" />
                <button type="button" className="btn btn-default float-right btn-lg"> </button>
                </span>
            </div>
        );
    }

}

export default SearchBox
