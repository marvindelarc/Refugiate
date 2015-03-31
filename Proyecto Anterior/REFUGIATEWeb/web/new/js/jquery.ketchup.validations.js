jQuery.ketchup

.validation('required', 'Este campo es obligatorio.', function(form, el, value) {
  var type = el.attr('type').toLowerCase();
  
  if(type == 'checkbox' || type == 'radio') {
    return (el.attr('checked') == true);
  } else {
    return (value.length != 0);
  }
})

.validation('minlength', 'Este campo debe tener una longitud mínima de {arg1}.', function(form, el, value, min) {
  return (value.length >= +min);
})

.validation('maxlength', 'Este campo debe tener una longitud máxima de {arg1}.', function(form, el, value, max) {
  return (value.length <= +max);
})

.validation('rangelength', 'Este campo debe tener una longitud de entre {arg1} y {arg2}.', function(form, el, value, min, max) {
  return (value.length >= min && value.length <= max);
})

.validation('min', 'Puede tener como minimo {arg1}.', function(form, el, value, min) {
  return (this.isNumber(value) && +value >= +min);
})

.validation('max', 'No puede ser mayor a {arg1}.', function(form, el, value, max) {
  return (this.isNumber(value) && +value <= +max);
})

.validation('range', 'Debe estar entre {arg1} y {arg2}.', function(form, el, value, min, max) {
  return (this.isNumber(value) && +value >= +min && +value <= +max);
})

.validation('number', 'Debe ser un número.', function(form, el, value) {
  return this.isNumber(value);
})

.validation('digits', 'Debe ser dígitos.', function(form, el, value) {
  return /^\d+$/.test(value);
})

.validation('email', 'Debe ser un e-mail válida.', function(form, el, value) {
  return this.isEmail(value);
})

.validation('url', 'Debe ser una URL válida.', function(form, el, value) {
  return this.isUrl(value);
})

.validation('username', 'Debe ser un nombre de usuario válido.', function(form, el, value) {
  return this.isUsername(value);
})

.validation('match', 'Debe ser {arg1}.', function(form, el, value, word) {
  return (el.val() == word);
})

.validation('contain', 'Debe contener {arg1}', function(form, el, value, word) {
  return this.contains(value, word);
})

.validation('date', 'Debe ser una fecha válida.', function(form, el, value) {
  return this.isDate(value);
})

.validation('minselect', 'Seleccione al menos {arg1} casillas.', function(form, el, value, min) {
  return (min <= this.inputsWithName(form, el).filter(':checked').length);
}, function(form, el) {
  this.bindBrothers(form, el);
})

.validation('maxselect', 'Seleccione no más de {arg1} casillas.', function(form, el, value, max) {
  return (max >= this.inputsWithName(form, el).filter(':checked').length);
}, function(form, el) {
  this.bindBrothers(form, el);
})

.validation('rangeselect', 'Seleccione entre {arg1} y {arg2} casillas.', function(form, el, value, min, max) {
  var checked = this.inputsWithName(form, el).filter(':checked').length;
  
  return (min <= checked && max >= checked);
}, function(form, el) {
  this.bindBrothers(form, el);
});