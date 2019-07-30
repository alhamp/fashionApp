import React, {Component} from 'react';
import TextField from '../components/TextField'
import SelectField from '../components/SelectField'
import TextArea from '../components/TextArea'
import NumberField from '../components/NumberField'

const stylesArray =['formal-office','business-casual','casual-chic','sports-wear',
        'evening-black-tie','party/wedding','pool-party','vocation','maternity','streetWear',
        'cowGirl','hip-hop','rocker-chick','military']

class FashionItemFormContainer extends Component {
constructor(props){
    super(props);
    this.state = {
        name: '',
        clothingType:'',
        bodyType:'',
        measurements:'',
        styles:[],
        brand:'',
        fabricWeight:'',
        quality:'',
        itemSize:'',
        photo:'',
        budget:'',
        comment:''
    };
    this.handleSubmit = this.handleSubmit.bind(this)
    this.clearForm = this.clearForm.bind(this)
    this.handleChange = this.handleChange.bind(this)
    this.handleCheckbox = this.handleCheckbox.bind(this)
}

handleChange(event) {
  this.setState({ [event.target.name]: event.target.value})
}

handleCheckbox(event){
    if(this.state.styles.find(function(element) { return element == event.target.value})) {
        this.setState({styles:this.state.styles.splice(this.state.styles.indexOf(event.target.value), 1)})
    }
    else {
        this.setState({styles:this.state.styles.concat(event.target.value)})
    }
}


handleSubmit(event) {
    event.preventDefault()
    let item = {name:this.state.name,
        clothing_type_id:this.state.clothingType,
        bodyType:this.state.bodyType,
        measurements:this.state.measurements,
        styles:this.state.styles,
        brand_id:this.state.brand,
        fabricWeight:this.state.fabricWeight,
        quality:this.state.quality,
        itemSize:this.state.itemSize,
        photo:this.state.photo,
        budget_id:this.state.budget,
        comment:this.state.comment
    }
    debugger
    this.props.addNewFashionItem(item)
    this.clearForm()
}

clearForm(){
    this.setState({
        name: '',
        clothingType:'',
        bodyType:'',
        measurements:'',
        styles:[],
        brand:'',
        fabricWeight:'',
        quality:'',
        itemSize:'',
        photo:'',
        budget:'',
        comment:''
    })
}

render() {

        let clothingTypeArray = ['Tops','jackets','blazers', 'coats','dresses',
        'jumpsuits','knitwear','shirts|blouses','t-shirts','pants','jeans','shorts',
        'skirts','swimwear']
        let clothingTypeOptions = clothingTypeArray.map((name, i) => {
            return <option key={i} value={i}>{name}</option>
        })

        let bodyTypeArray = ['straight-body','pear-body','oval-body', 'diamond-body','hourglass-body','top-hourglass-body','inverted-triangle-body',]
        let bodyTypeOptions = bodyTypeArray.map((name, i) => {
            return <option key={i} value={i}>{name}</option>
        })

        let sizeArray = ['US 0', 'US 2', 'US 4', 'US 8', 'US 10', 'US 12', 'US 14', 'US 16', 'US 18', 'US 20']
        let sizeOptions = sizeArray.map((name, i) => {
            return <option key={i} value={i}>{name}</option>
        })

        
        let stylesOptions = stylesArray.map((name, i) => {
            //return <option key={i} value={i}>{name}</option>
            return <div key={i} >
                <label>{name}</label>
                <input type="checkbox" name="styles" value={i} onClick={this.handleCheckbox}/>
            </div>
        })
        let options =[]
        for(let i=1; i<6; i++) {
            options.push(<option key={i} value={i}>{i}</option>)
        }

        return (
            <form onSubmit={this.handleSubmit}>
                <h2>Add Your Fashion Item:</h2>
                <TextField
                    label="Fashion Item Name"
                    name="name"
                    handleChange={this.handleChange}
                    value={this.state.name}
                />
                <div>
                <TextField
                    label="Brand"
                    name="brand"
                    handleChange={this.handleChange}
                    value={this.state.brand}
                />
                </div>
                <div>
                <SelectField
                    label="Clothing Type"
                    name="clothingType"
                    optionElements={clothingTypeOptions}
                    handleChange={this.handleChange}
                    value={this.state.clothingType}
                    />
                </div>
                <div>
                <SelectField
                    label="Size"
                    name="itemSize"
                    optionElements={sizeOptions}
                    handleChange={this.handleChange}
                    value={this.state.itemSize}
                />
                </div>
                <div>
                <SelectField
                    label="Body Type"
                    name="bodyType"
                    optionElements={bodyTypeOptions}
                    handleChange={this.handleChange}
                    value={this.state.bodyType}
                />
                   </div>
                   <div>
                 <TextField
                     label="Measurements"
                     name="measurements"
                     handleChange={this.handleChange}
                     value={this.state.measurements}
                 />
                  </div>
                  <div>
                {/* <SelectField
                    label="Styles to match"
                    name="styles"
                    optionElements={stylesOptions}
                    handleChange={this.handleChange}
                    value={this.state.styles}
                /> */}
                <p>Styles</p>
                {stylesOptions}
                
                </div>
                <div>
                   <NumberField
                    label="Price"
                    name="budget"
                    handleChange={this.handleChange}
                    value={this.state.budget}
                />
                </div>
                <div>
                    <TextField
                        label="Photo"
                        name="photo"
                        handleChange={this.handleChange}
                        value={this.state.photo}
                    />
                </div>
                <SelectField
                    label="Quality"
                    name="quality"
                    optionElements={options}
                    handleChange={this.handleChange}
                    value={this.state.quality}
                />
                <div>
                    <TextArea
                        label="Comment"
                        name="comment"
                        handleChange={this.handleChange}
                        value={this.state.comment}
                    />
                </div>
                <div>
                <input className="button" type="submit" value="Add your item" />
                </div>
            </form>
        )
    }
 }

export default FashionItemFormContainer;