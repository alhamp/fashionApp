import React, {Component} from 'react';
import TextField from '../components/TextField'
import SelectField from '../components/SelectField'

const stylesArray =['formal-office','business-casual','casual-chic','sports-wear',
        'evening-black-tie','party/wedding','pool-party','vocation','maternity','streetWear',
        'cowGirl','hip-hop','rocker-chick','military']

const clothingTypeArray = ['tops','jackets','blazers', 'coats','dresses',
        'jumpsuits','knitwear','shirts|blouses','t-shirts','pants','jeans','shorts',
        'skirts','swimwear']

const bodyTypeArray = ['straight-body','pear-body','oval-body', 'diamond-body','hourglass-body','top-hourglass-body','inverted-triangle-body']

const sizeArray = ['US 0', 'US 2', 'US 4', 'US 8', 'US 10', 'US 12', 'US 14', 'US 16', 'US 18', 'US 20']

const budgetArray = [25, 50, 100, 200, 300, 400, 500, 600]

class FashionItemFormContainer extends Component {
constructor(props){
    super(props);
    this.state = {
        name: '',
        clothingType:'',
        bodyType:'',
        measurements:'',
        style:'',
        brand:'',
        fabricWeight:'',
        quality:'',
        itemSize:'',
        photo:'',
        budget:''
    };
    this.handleSubmit = this.handleSubmit.bind(this)
    this.clearForm = this.clearForm.bind(this)
    this.handleChange = this.handleChange.bind(this)
}

handleChange(event) {
  this.setState({ [event.target.name]: event.target.value})
}

handleSubmit(event) {
    event.preventDefault()
    let item = {
        id:this.props.number,
        name:this.state.name.trim(),
        clothingType:this.state.clothingType.trim(),
        bodyType:this.state.bodyType.trim(),
        measurements:this.state.measurements.trim(),
        style:this.state.style.trim(),
        brand:this.state.brand.trim(),
        fabricWeight:this.state.fabricWeight.trim(),
        quality:this.state.quality.trim(),
        itemSize:this.state.itemSize.trim(),
        photo:this.state.photo.trim(),
        budget:this.state.budget.trim(),
    }
    this.props.handleItem(item)
    this.clearForm()
}

clearForm(){
    this.setState({
        name: '',
        clothingType:'',
        bodyType:'',
        measurements:'',
        style:'',
        brand:'',
        fabricWeight:'',
        quality:'',
        itemSize:'',
        photo:'',
        budget:'',
    })
}
render() {
        let clothingTypeOptions = clothingTypeArray.map((name, i) => {
            return <option key={i} value={name}>{name}</option>
        })

        let bodyTypeOptions = bodyTypeArray.map((name, i) => {
            return <option key={i} value={name}>{name}</option>
        })

        let sizeOptions = sizeArray.map((name, i) => {
            return <option key={i} value={i}>{name}</option>
        })
        
        let stylesOptions = stylesArray.map((name, i) => {
            return <option key={i} value={name}>{name}</option>
        })
        let options =[]
        for(let i=1; i<6; i++) {
            options.push(<option key={i} value={i}>{i}</option>)
        }
        let budgetOptions = budgetArray.map((amount, i) => {
            return <option key={i} value={amount}>{amount}</option>
        })

        return (
            <form onSubmit={this.handleSubmit}>
                <h4>Add Your Fashion Item:</h4>
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
                 <SelectField
                    label="Styles to match"
                    name="style"
                    optionElements={stylesOptions}
                    handleChange={this.handleChange}
                    value={this.state.styles}
                />
                </div>
                <div>
                   <SelectField
                    label="Budget Category"
                    name="budget"
                    optionElements={budgetOptions}
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
                    <input className="button" type="submit" value="Add your item" />
                </div>
            </form>
        )
    }
 }

export default FashionItemFormContainer;