/*!
 * i18n add-on
 * This add-on allows to define message in multiple languages
 *
 * @link        http://formvalidation.io/addons/i18n/
 * @license     http://formvalidation.io/license/
 * @author      https://twitter.com/formvalidation
 * @copyright   (c) 2013 - 2015 Nguyen Huu Phuoc
 * @version     v0.1.0, built on 2015-04-02 8:57:55 PM
 */
!function(){FormValidation.AddOn.i18n={init:function(a){this._setMessage(a);var b=this,c=a.getOptions();a.getForm().on(c.events.localeChanged,function(a,c){b._setMessage(c.fv)})},_setMessage:function(a){var b=a.getOptions(),c=a.getLocale();for(var d in b.fields)if(b.fields[d].validators)for(var e=a.getFieldElements(d),f=e.attr("type"),g="radio"===f||"checkbox"===f?1:e.length,h=0;g>h;h++){var i=e.eq(h);for(var j in b.fields[d].validators){var k=b.fields[d].validators[j].message,l=typeof k,m=null;if("undefined"===l&&FormValidation.I18n[c][j]["default"])m=FormValidation.I18n[c][j]["default"];else if("object"===l&&k[c])m=k[c];else if("function"===l){var n=k.apply(this,[a,i,j]);n&&n[c]&&(m=n[c])}m&&a.updateMessage(d,j,m)}}}}}(jQuery);